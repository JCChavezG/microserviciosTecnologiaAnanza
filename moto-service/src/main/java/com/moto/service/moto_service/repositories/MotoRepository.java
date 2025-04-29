package com.moto.service.moto_service.repositories;

import com.moto.service.moto_service.entities.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Integer> {
    List<Moto>findByUsuarioId(int usuarioId);
}
