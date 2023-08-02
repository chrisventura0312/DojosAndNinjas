package com.codingdojo.dojosandninjas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.repository.DojoRepository;

import com.codingdojo.dojosandninjas.models.Dojo;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // create a dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    // retrieve a dojo
    public Dojo findDojoById(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

    // update a dojo
    public Dojo updateDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    // delete a dojo
    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }

    // retrieve all dojos
    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }
}
