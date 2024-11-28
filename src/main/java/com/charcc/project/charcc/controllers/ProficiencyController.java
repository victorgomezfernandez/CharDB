package com.charcc.project.charcc.controllers;

import com.charcc.project.charcc.repositories.ProficiencyRepository;
import com.charcc.project.charcc.models.Proficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.charcc.project.charcc.ResourceNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/charcc/proficiencies")
public class ProficiencyController {
    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @GetMapping
    public List<Proficiency> getProficiencies() { return proficiencyRepository.findAll(); }

    @PostMapping
    public Proficiency putProficiency(@RequestBody Proficiency proficiency) {
        return proficiencyRepository.save(proficiency);
    }

    @GetMapping("/{id}")
    public Proficiency getProficiency(@PathVariable("id") Long id) {
        return proficiencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proficiency not found"));
    }

    @PutMapping("/{id}")
    public  Proficiency putProficiency(@PathVariable("id") Long id, @RequestBody Proficiency charcc_proficiency) {
        Proficiency proficiency = proficiencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proficiency not found"));
        proficiency.setName(charcc_proficiency.getName());
        proficiency.setDescription(charcc_proficiency.getDescription());
        return proficiencyRepository.save(proficiency);
    }

    @DeleteMapping("/{id}")
    public Proficiency deleteProficiency(@PathVariable("id") Long id) {
        Proficiency proficiency = proficiencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proficiency not found"));
        proficiencyRepository.deleteById(id);
        return proficiency;
    }
}
