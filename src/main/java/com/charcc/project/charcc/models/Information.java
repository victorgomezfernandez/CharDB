package com.charcc.project.charcc.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private int level;
    private String charClass;
    private String race;
    private String factions;
    private String traits;
    private String ideals;
    private String flaws;
    private String bonds;
    private String backstory;

    @OneToOne(mappedBy = "information", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Stats stats;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }

    public String getCharClass() {
        return charClass;
    }

    public String getRace() {
        return race;
    }

    public String getFactions() {
        return factions;
    }

    public String getTraits() {
        return traits;
    }

    public String getIdeals() {
        return ideals;
    }

    public String getFlaws() {
        return flaws;
    }

    public String getBonds() {
        return bonds;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setFactions(String factions) {
        this.factions = factions;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public Information() {
    }
}
