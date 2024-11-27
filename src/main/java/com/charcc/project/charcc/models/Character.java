package com.charcc.project.charcc.models;

import jakarta.persistence.*;

@Entity
@Table(name = "charcc_character")
public class Character {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public Character() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
