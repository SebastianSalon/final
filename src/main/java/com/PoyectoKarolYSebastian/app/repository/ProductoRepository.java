package com.PoyectoKarolYSebastian.app.repository;

import com.PoyectoKarolYSebastian.app.entidades.Producto;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends MongoRepository<Producto, Long> {
    
}