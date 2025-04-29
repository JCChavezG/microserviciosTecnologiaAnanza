package com.auth.service.usuario_service.repository;

import com.auth.service.usuario_service.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer > {
}
