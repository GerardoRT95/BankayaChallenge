package com.bankaya.pokemon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankaya.pokemon.dao.Peticion;

@Repository
public interface PeticionRepository extends CrudRepository<Peticion, Long>{

}
