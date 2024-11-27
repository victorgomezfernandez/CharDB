package com.charcc.project.charcc.models;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String language;

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Language() {

    }
}
