package com.example.stoixhwomanrebooted.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char specifier;
    private Double odd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getSpecifier() {
        return specifier;
    }

    public void setSpecifier(char specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}
