package com.codingdojo.dojosandninjas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.dojosandninjas.models.Ninja;


public interface NinjaRepository extends CrudRepository<Ninja, Long> {
        // this method retrieves all the books from the database
        List<Ninja> findAll();

        Optional<Ninja> findById(Long id);

    }



