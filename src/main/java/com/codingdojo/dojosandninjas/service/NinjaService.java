package com.codingdojo.dojosandninjas.service;



import org.springframework.stereotype.Service;


import com.codingdojo.dojosandninjas.repository.NinjaRepository;
import com.codingdojo.dojosandninjas.models.Ninja;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Add methods to handle ninja-related operations, such as saving ninjas, fetching ninjas by ID, etc.
    // For example:

    public Ninja saveNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public Ninja findNinjaById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }


}
