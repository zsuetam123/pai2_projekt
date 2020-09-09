package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VOTING_RESULTS")
@EnableAutoConfiguration

public class VotingResults{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @OneToOne
    private Candidates candidates;

    private Integer numberOfVotes;

    @OneToOne
    private DatesOfVoting dateOfVoting;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Candidates getCandidates(){
        return candidates;
    }
    public void setCandidates(Candidates candidates){
        this.candidates = candidates;
    }

    public Integer getNumberOfVotes(){
        return numberOfVotes;
    }
    public void setNumberOfVotes(Integer numberOfVotes){
        this.numberOfVotes = numberOfVotes;
    }

    public DatesOfVoting getDateOfVoting() {return dateOfVoting; }
    public void setDateOfVoting(DatesOfVoting dateOfVoting) {this.dateOfVoting = dateOfVoting; }
}