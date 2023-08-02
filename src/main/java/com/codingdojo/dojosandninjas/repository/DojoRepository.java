package com.codingdojo.dojosandninjas.repository;
//=====Java Imports=====//
import java.util.List;
import java.util.Optional;

//====Spring Imports====//
import org.springframework.data.repository.CrudRepository;
//=====Local Imports=====//
import com.codingdojo.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();

    Optional<Dojo> findById(Long id);

}
