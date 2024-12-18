package com.charcc.project.charcc.controllers;

import com.charcc.project.charcc.repositories.InformationRepository;
import com.charcc.project.charcc.models.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.charcc.project.charcc.ResourceNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/charcc/informations")
public class InformationController {
    @Autowired
    private InformationRepository informationRepository;

    @GetMapping
    public List<Information> findAll() {
        return informationRepository.findAll();
    }

    @PostMapping
    public Information putInformation(@RequestBody Information information) {
        return informationRepository.save(information);
    }

    @GetMapping("/{id}")
    public Information findById(@PathVariable Long id) {
        return informationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Information not found"));
    }

    @PutMapping("/{id}")
    public Information updateInformation(@PathVariable Long id, @RequestBody Information chacc_information) {
        Information information = informationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Information not found"));
        information.setName(chacc_information.getName());
        information.setAge(chacc_information.getAge());
        information.setLevel(chacc_information.getLevel());
        information.setCharClass(chacc_information.getCharClass());
        information.setRace(chacc_information.getRace());
        information.setFactions(chacc_information.getFactions());
        information.setTraits(chacc_information.getTraits());
        information.setIdeals(chacc_information.getIdeals());
        information.setFlaws(chacc_information.getFlaws());
        information.setBonds(chacc_information.getBonds());
        information.setBackstory(chacc_information.getBackstory());
        return informationRepository.save(information);
    }

    @DeleteMapping("/{id}")
    public Information deleteInformation(@PathVariable("id") Long id){
        Information information = informationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Information not found"));
        informationRepository.deleteById(id);
        return information;
    }
}
