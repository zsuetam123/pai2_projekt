package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DATES_OF_VOTING")
@EnableAutoConfiguration

public class DatesOfVoting{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfVoting;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Date getDateOfVoting(){
        return dateOfVoting;
    }
    public void setDateOfVoting(Date dateOfVoting){
        this.dateOfVoting = dateOfVoting;
    }

}