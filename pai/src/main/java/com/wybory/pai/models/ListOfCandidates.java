package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "LIST_OF_CANDIDATES")
@EnableAutoConfiguration

public class ListOfCandidates{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private DatesOfVoting dateOfVoting;
    @ManyToOne
    private Candidates candidates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidates getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidates candidates) {
        this.candidates = candidates;
    }

    public DatesOfVoting getDateOfVoting(){
        return dateOfVoting;
    }
    public void setDateOfVoting (DatesOfVoting dateOfVoting){
        this.dateOfVoting = dateOfVoting;
    }
}