package com.PoyectoKarolYSebastian.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.PoyectoKarolYSebastian.app.entidades.Citas;

@Repository
public interface CitasRepository extends MongoRepository<Citas, Long>{

}
