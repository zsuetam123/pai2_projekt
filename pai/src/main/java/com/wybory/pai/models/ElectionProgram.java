package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "ELECTION_PROGRAM")
@EnableAutoConfiguration

public class ElectionProgram{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @OneToOne
    private ElectionStaff electionStaff;

    private String demands;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public ElectionStaff getElectionStaff(){
        return electionStaff;
    }
    public void setElectionStaff(ElectionStaff electionStaff){
        this.electionStaff= electionStaff;
    }

    public String getDemands(){
        return demands;
    }
    public void setDemands(String demands){
        this.demands = demands;
    }

    @Override
    public String toString() {
        return demands;
    }
}