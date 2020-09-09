package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "VOTE")
@EnableAutoConfiguration

public class Vote{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @OneToOne
    private User voter;

    @OneToOne
    private Candidates candidates;

    @OneToOne
    private DatesOfVoting datesOfVoting;

    public User getVoter(){
        return voter;
    }
    public void setVoter(User voter){
        this.voter = voter;
    }

    public Candidates getCandidates(){
        return candidates;
    }
    public void setCandidates(Candidates candidates){
        this.candidates = candidates;
    }

    public DatesOfVoting getDatesOfVoting(){
        return datesOfVoting;
    }
    public void setDatesOfVoting(DatesOfVoting datesOfVoting){
        this.datesOfVoting = datesOfVoting;
    }
}