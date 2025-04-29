package com.carro.service.carri_service.repositories;

import com.carro.service.carri_service.Entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro>findByUsuarioId(int usuarioId);
}
