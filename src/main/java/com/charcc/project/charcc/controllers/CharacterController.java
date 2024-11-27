package com.charcc.project.charcc.controllers;


import com.charcc.project.charcc.repositories.CharacterRepository;
import com.charcc.project.charcc.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // Permite solicitudes desde Ionic
@RestController
@RequestMapping("/api/charcc")
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    @PostMapping
    public Character putCharacter(@RequestBody Character charcc_character) {
        return characterRepository.save(charcc_character);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable ("id") Long id) {
        return characterRepository.findById(id);
    }
}