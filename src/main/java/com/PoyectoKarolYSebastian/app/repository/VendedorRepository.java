package com.PoyectoKarolYSebastian.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.PoyectoKarolYSebastian.app.entidades.Vendedor;

@Repository
public interface VendedorRepository extends MongoRepository<Vendedor, Long>{

}
