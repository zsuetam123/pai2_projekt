package com.wybory.pai.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@EnableAutoConfiguration

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    @Column(unique = true)
    private String login;
    private String password;
    private String name;
    private String surname;
    private Long pesel;
    private String locality;
    private String adressEmail;

    @OneToOne
    private Candidates favCandidate;

    @OneToOne
    private Permission permission;

    public User(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
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

    public Long getPesel(){
        return pesel;
    }
    public void setPesel(Long pesel){
        this.pesel=pesel;
    }

    public String getLocality(){
        return locality;
    }
    public void setLocality(String locality){
        this.locality = locality;
    }

    public String getAdressEmail(){
        return adressEmail;
    }
    public void setAdressEmail(String adressEmail){
        this.adressEmail = adressEmail;
    }

    public Permission getPermission(){
        return permission;
    }
    public void setPermission(Permission permission){
        this.permission=permission;
    }

    public Candidates getfavCandidate(){
        return favCandidate;
    }
    public void setfavCandidate(Candidates favCandidate){
        this.favCandidate = favCandidate;
    }

    /*
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", haslo='" + password + '\'' +
                ", imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", miejscowosc='" + locality + '\'' +
                ", email='" + adressEmail + '\'' +
                ", pozwolenie='" + permission.toString() + '\'' +
                '}';
    }
*/

    @Override
    public String toString() {
return adressEmail;
    }

}