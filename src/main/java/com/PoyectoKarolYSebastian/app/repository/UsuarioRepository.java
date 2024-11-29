package com.PoyectoKarolYSebastian.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.PoyectoKarolYSebastian.app.entidades.usuario;

public interface UsuarioRepository extends MongoRepository<usuario, Long> {
    Optional<usuario> findByUsuarioAndContraseña(String usuario, String contraseña);
    
    List<usuario> findByTipousuario(String tipousuario);
}
