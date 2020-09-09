package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "ELECTION_STAFF_MEMBERS")
@EnableAutoConfiguration

public class ElectionStaffMembers{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    @OneToOne
    private ElectionStaff electionStaff;

    private String name;
    private String surname;
    private String position;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public ElectionStaff getElectionStaff(){
        return electionStaff;
    }
    public void setElectionStaff(ElectionStaff electionStaff){
        this.electionStaff = electionStaff;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }

}