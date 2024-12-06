package com.charcc.project.charcc.controllers;

import com.charcc.project.charcc.repositories.InformationRepository;
import com.charcc.project.charcc.repositories.CharacterRepository;  // Importa el repositorio de Character
import com.charcc.project.charcc.models.Information;
import com.charcc.project.charcc.models.Character;  // Importa la clase Character
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

    @Autowired
    private CharacterRepository characterRepository; // Inyecta el repositorio de Character

    @GetMapping
    public List<Information> findAll() {
        return informationRepository.findAll();
    }

    @PostMapping
    public Information putInformation(@RequestBody Information information) {
        try {
            if (information.getCharacter() != null && information.getCharacter().getId() != null) {
                Character character = characterRepository.findById(information.getCharacter().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
                information.setCharacter(character);
            } else {
                throw new IllegalArgumentException("Character ID must be provided");
            }

            return informationRepository.save(information);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la información", e);
        }
    }


    @GetMapping("/{id}")
    public Information findById(@PathVariable Long id) {
        return informationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Information not found"));
    }

    @PutMapping("/{id}")
    public Information updateInformation(@PathVariable Long id, @RequestBody Information chacc_information) {
        Information information = informationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Information not found"));

        // Obtener el Character por su ID y asignarlo a la Information
        Character character = characterRepository.findById(chacc_information.getCharacter().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Character not found"));
        information.setCharacter(character);  // Asociar el Character

        // Actualizar los demás campos de Information
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

        // Guardar la entidad actualizada
        return informationRepository.save(information);
    }

    @DeleteMapping("/{id}")
    public Information deleteInformation(@PathVariable("id") Long id) {
        Information information = informationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Information not found"));
        informationRepository.deleteById(id);
        return information;
    }
}
