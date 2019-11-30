package com.prueba.desarrollo.pojo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ValidCharacter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String character;

    public ValidCharacter() {
    }

    public ValidCharacter(Long id, String character) {
        this.id = id;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
