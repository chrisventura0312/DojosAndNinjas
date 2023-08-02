package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.service.DojoService;
import com.codingdojo.dojosandninjas.service.NinjaService;

@Controller
public class DojoControllers {

    private final DojoService dojoService;
    private final NinjaService ninjaService;

    
    public DojoControllers(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    // === Dojo Controllers ===

    @GetMapping("/")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("dojo", new Dojo());
        return "index.jsp";
    }

    @PostMapping("/dojos/add")
    public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Handle validation errors if any
            List<Dojo> dojos = dojoService.getAllDojos();
            model.addAttribute("dojos", dojos); // Add existing dojo data to the model
            return "index.jsp"; // Return to the form page to display errors
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/"; // Redirect to the index page after successful submission
        }
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojoById(id);
        if (dojo != null) {
            model.addAttribute("dojo", dojo);
            model.addAttribute("ninjas", dojo.getNinjas()); // Add the list of ninjas to the model
            return "dojo.jsp";
        } else {
            return "redirect:/"; // Redirect to the index page if the dojo with the given ID is not found
        }
    }

    @GetMapping("/dojos/{id}/edit")
    public String editDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojoById(id);
        if (dojo != null) {
            model.addAttribute("dojo", dojo);
            return "edit.jsp";
        } else {
            return "redirect:/"; // Redirect to the index page if the dojo with the given ID is not found
        }
    }

    @PutMapping("/dojos/{id}")
    public String updateDojo(@PathVariable("id") Long id, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors if any
            return "edit.jsp"; // Return to the edit page to display errors
        } else {
            dojoService.updateDojo(dojo);
            return "redirect:/"; // Redirect to the index page after successful update
        }
    }

    @DeleteMapping("/dojos/{id}")
    public String deleteDojo(@PathVariable("id") Long id) {
        dojoService.deleteDojo(id);
        return "redirect:/"; // Redirect to the index page after successful deletion
    }

    // === Ninja Controllers ===

    @GetMapping("/ninjas/new")
    public String showCreateNinjaForm(Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninja", new Ninja());
        return "createNinja.jsp";
    }

    @PostMapping("/ninjas/add")
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Dojo> dojos = dojoService.getAllDojos();
            model.addAttribute("dojos", dojos);
            return "createNinja.jsp"; // Return to the form page to display errors
        } else {
            ninjaService.saveNinja(ninja);
            Long dojoId = ninja.getDojo().getId();
            return "redirect:/dojos/" + dojoId; // Redirect to the dojo page using the dojo ID
        }
    }
}