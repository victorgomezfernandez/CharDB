package com.charcc.project.charcc.controllers;

import com.charcc.project.charcc.repositories.InformationRepository;
import com.charcc.project.charcc.models.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.charcc.project.charcc.ResourceNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*") // Permite solicitudes desde Ionic
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

//    @GetMapping("/{id}")
//    public Information findById(@PathVariable Long id) {
//        return informationRepository.
//    }
}
