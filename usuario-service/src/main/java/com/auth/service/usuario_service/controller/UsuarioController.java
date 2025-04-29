package com.auth.service.usuario_service.controller;

import com.auth.service.usuario_service.entities.Usuario;
import com.auth.service.usuario_service.models.Carro;
import com.auth.service.usuario_service.models.Moto;
import com.auth.service.usuario_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.getAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
           return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id){

        Usuario usuario= usuarioService.usuarioGetById(id);
        if(usuario== null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
        return  ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/carro/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int id){
        Usuario usuario = usuarioService.usuarioGetById(id);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Carro> carros = usuarioService.getCarros(id);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int id){
        Usuario usuario = usuarioService.usuarioGetById(id);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioService.getMotos(id);
        return ResponseEntity.ok(motos);
    }

    @PostMapping("/carros/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int usuarioId, @RequestBody Carro carro){
        Carro nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
        return  ResponseEntity.ok(nuevoCarro);
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto){
        Moto nuevaMoto = usuarioService.saveMoto(usuarioId, moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String,Object>>listartodoslosVehiculos(@PathVariable("usuarioId") int usuarioId){

        Map<String,Object> resultado = usuarioService.getUsuarioyVehiculos(usuarioId);
        return ResponseEntity.ok(resultado);
    }
}
