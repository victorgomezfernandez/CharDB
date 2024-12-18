package com.charcc.project.charcc.controllers;

import com.charcc.project.charcc.repositories.StatsRepository;
import com.charcc.project.charcc.models.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.charcc.project.charcc.ResourceNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/charcc/stats")
public class StatsController {
    @Autowired
    private StatsRepository statsRepository;

    @GetMapping
    public List<Stats> getStats() {
        return statsRepository.findAll();
    }

    @PostMapping
    public Stats putStats(@RequestBody Stats stats) {
        return statsRepository.save(stats);
    }

    @GetMapping("/{id}")
    public Stats getStatsById(@PathVariable Long id) {
        return statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stats not found"));
    }

    @PutMapping
    public Stats putStats(@PathVariable ("id") Long id, @RequestBody Stats charcc_stats) {
        Stats stats = statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stats not found"));
        stats.setStrength(charcc_stats.getStrength());
        stats.setDexterity(charcc_stats.getDexterity());
        stats.setConstitution(charcc_stats.getConstitution());
        stats.setIntelligence(charcc_stats.getIntelligence());
        stats.setWisdom(charcc_stats.getWisdom());
        stats.setCharisma(charcc_stats.getCharisma());
        return statsRepository.save(stats);
    }

    @DeleteMapping("/{id}")
    public Stats deleteStats(@PathVariable ("id") Long id) {
        Stats stats = statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stats not found"));
        statsRepository.delete(stats);
        return stats;
    }

    public List<Stats> getStatsByCharacterId(Long characterId) {
        return statsRepository.findByCharacterId(characterId);
    }
}
