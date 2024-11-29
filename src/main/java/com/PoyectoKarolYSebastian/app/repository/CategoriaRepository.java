package com.PoyectoKarolYSebastian.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.PoyectoKarolYSebastian.app.entidades.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, Long> {
    
}
