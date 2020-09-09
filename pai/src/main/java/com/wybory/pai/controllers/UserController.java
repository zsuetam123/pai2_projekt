package com.wybory.pai.controllers;

import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.DatesOfVotingRepo;
import com.wybory.pai.repository.ElectionProgramRepo;
import com.wybory.pai.repository.LoginRepo;
import com.wybory.pai.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.wybory.pai.models.ElectionProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    ElectionProgramRepo electionRepo;

    @Autowired
    LoginRepo repo;

    @Autowired
    VoteRepo voteRepo;

    @Autowired
    DatesOfVotingRepo dates;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("candidates")
    ResponseEntity<List> candidatesOdp(){

        List<ElectionProgram> candidatesList = electionRepo.findAll();

        return new ResponseEntity<>(candidatesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("electionStaff")
    ResponseEntity<List> electionStaffOdp(){

        List<ElectionProgram> candidatesList = electionRepo.findAll();

        return new ResponseEntity<>(candidatesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("votingcheck")
    ResponseEntity<String> votingcheckOdp(@RequestParam("userId") Long userId, @RequestParam("dateOfVoting") String votingDate) throws ParseException {

        User user = repo.findUserById(userId);

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");

        String d1 = votingDate;
        Date d2 = formatter1.parse(d1);
        d1 = formatter2.format(d2);
        d2 = formatter2.parse(d1);

        DatesOfVoting datesOfVoting = dates.findDatesOfVotingBydateOfVoting(d2);

        if (voteRepo.findVoteByVoterAndDatesOfVoting(user, datesOfVoting) == null) {
            String alreadyVoted = "ableToVote";

            return new ResponseEntity<>(alreadyVoted, HttpStatus.OK);
        }else{
            String alreadyVoted = "alreadyVoted";
            return new ResponseEntity<>(alreadyVoted, HttpStatus.OK);
        }
    }
}
