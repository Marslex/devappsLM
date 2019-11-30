package com.prueba.desarrollo.pojo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Operator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String character;
    private int precedence;

    public Operator(String character, int precedence) {
        this.character = character;
        this.precedence = precedence;
    }

    public Operator() {
    }

    public String getCharacter() {
        return character;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }
}
