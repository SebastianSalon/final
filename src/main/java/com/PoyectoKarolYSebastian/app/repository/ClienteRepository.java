package com.PoyectoKarolYSebastian.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.PoyectoKarolYSebastian.app.entidades.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long>{

	Optional<Cliente> findByUsuario(String usuario);
}
