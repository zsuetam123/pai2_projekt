package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION")
@EnableAutoConfiguration

public class Permission{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)


    private Integer id;
    private String name;

    public Integer getId(){ return id; }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString() { return  name; }

    //public Integer getId(int id){ return id; }
}
