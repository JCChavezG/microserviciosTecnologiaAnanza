package com.moto.service.moto_service.service;

import com.moto.service.moto_service.entities.Moto;
import com.moto.service.moto_service.repositories.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class MotoService {

    @Autowired
    private  MotoRepository motoRepository;

    public List<Moto>getAll(){
        return motoRepository.findAll();
    }

    public Moto getMotoById(int id){
        return motoRepository.findById(id).orElse(null);
    }

    public Moto save(Moto moto){
        Moto motonueva= motoRepository.save(moto);
        return motonueva;
    }

    public List<Moto> getByUsuarioId(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }
}
