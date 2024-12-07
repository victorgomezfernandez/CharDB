package com.charcc.project.charcc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "charcc_character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "character", fetch = FetchType.EAGER)
    @JsonBackReference
    private Information information;

    //Bucle infinito
    @OneToOne(mappedBy = "character", fetch = FetchType.EAGER)
    private Stats stats;

    //No bucle infinito pero no inserta personaje
    /*@OneToOne(mappedBy = "character", fetch = FetchType.EAGER)
    @JsonBackReference
    private Stats stats;*/


    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
