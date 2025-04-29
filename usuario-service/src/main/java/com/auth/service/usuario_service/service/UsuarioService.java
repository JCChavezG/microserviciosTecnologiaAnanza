package com.auth.service.usuario_service.service;

import com.auth.service.usuario_service.entities.Usuario;
import com.auth.service.usuario_service.feingClient.CarroFeingClient;
import com.auth.service.usuario_service.feingClient.MotoFeingClient;
import com.auth.service.usuario_service.models.Carro;
import com.auth.service.usuario_service.models.Moto;
import com.auth.service.usuario_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarroFeingClient carroFeingClient;

    @Autowired
    private MotoFeingClient motoFeingClient;

    public List<Carro> getCarros(int usuarioId) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8082/carro/usuario/" + usuarioId, List.class);
        return carros;

    }

    public List<Moto> getMotos(int usuarioId) {
        List<Moto> motos = restTemplate.getForObject("http://localhost:8081/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario usuarioGetById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }

    public Carro saveCarro(int usuarioId, Carro carro) {
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carroFeingClient.save(carro);
        return nuevoCarro;
    }

    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto motonueva = motoFeingClient.save(moto);
        return  motonueva;
    }

    public Map<String, Object> getUsuarioyVehiculos(int usuarioId){

        Map<String, Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if( usuario==null){
            resultado.put("Mensaje","El usuario no existe");
            return resultado;
        }
        resultado.put("Usuario",usuario);
        List<Carro> carros = carroFeingClient.getCarros(usuarioId);
        if (carros.isEmpty()){
            resultado.put("Carros", "El uruario no tiene carros");
        }else{
            resultado.put("Caros",carros);
        }

        List<Moto>motos = motoFeingClient.getMotos(usuarioId);
        if ((motos.isEmpty())){
            resultado.put("Motos","El usuario no tiene motos");
        }else {
            resultado.put("Motos", motos);
        }
        return resultado;
    }

}
