package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "CANDIDATES")
@EnableAutoConfiguration

public class Candidates{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")

    private Long id;
    private String name;
    private String surname;

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname ;
    }
}