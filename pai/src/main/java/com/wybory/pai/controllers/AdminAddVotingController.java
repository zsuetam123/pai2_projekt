package com.wybory.pai.controllers;

import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.repository.DatesOfVotingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdminAddVotingController {

    @Autowired
    DatesOfVotingRepo datesRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("addVotingDate")
    ResponseEntity<String> adminAddVotingOdp(@RequestParam("data") String data) throws ParseException {

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");

        String d1 = data;
        Date d2 = formatter1.parse(d1);
        d1 = formatter2.format(d2);
        d2 = formatter2.parse(d1);

        DatesOfVoting voting = new DatesOfVoting();

        if((datesRepo.findDatesOfVotingBydateOfVoting(d2)) == null){
            voting.setDateOfVoting(d2);
            datesRepo.save(voting);
            return new ResponseEntity<>("Dodano głosowanie", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Termin zajety", HttpStatus.OK);
        }

    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("deleteVotingDate")
    ResponseEntity<String> deleteVotingDateOdp(@RequestParam("dayId") int dayId){

        DatesOfVoting dateToDelete = datesRepo.findDatesOfVotingById(dayId);

        if(dateToDelete != null){
            datesRepo.delete(dateToDelete);
            return new ResponseEntity<>("Usunięto głosowanie", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Błąd podczas usuwania głosowania", HttpStatus.OK);
        }

    }

}
