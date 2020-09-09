package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "ELECTION_STAFF")
@EnableAutoConfiguration

public class ElectionStaff{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @OneToOne
    private Candidates candidates;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id= id;
    }

    public Candidates getCandidates(){
        return candidates;
    }
    public void setCandidates(Candidates candidates){
        this.candidates = candidates;
    }
}