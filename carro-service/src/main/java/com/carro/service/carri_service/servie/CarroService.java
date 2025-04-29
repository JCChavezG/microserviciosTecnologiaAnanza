package com.carro.service.carri_service.servie;

import com.carro.service.carri_service.Entities.Carro;
import com.carro.service.carri_service.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getCarros(){
        return  carroRepository.findAll();
    }

    public Carro getCarroById(int id){
        return carroRepository.findById(id).orElse(null);
    }

    public Carro save(Carro carro){
        Carro nuevoCarro= carroRepository.save(carro);
        return nuevoCarro;
    }

    public List<Carro> getByUsuarioId(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }

}
