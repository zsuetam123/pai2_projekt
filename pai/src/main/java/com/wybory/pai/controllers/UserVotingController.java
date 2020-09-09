package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.User;
import com.wybory.pai.models.Vote;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.DatesOfVotingRepo;
import com.wybory.pai.repository.LoginRepo;
import com.wybory.pai.repository.VoteRepo;
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
public class UserVotingController {

    @Autowired
    LoginRepo repo;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    DatesOfVotingRepo dates;

    @Autowired
    VoteRepo voteRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/vote")
    ResponseEntity<String> candidatesOdp(@RequestParam("candidateId") Long candidateId, @RequestParam("userId") Long userId, @RequestParam("dateOfVoting") String votingDate) throws ParseException {

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");

        String d1 = votingDate;
        Date d2 = formatter1.parse(d1);
        d1 = formatter2.format(d2);
        d2 = formatter2.parse(d1);

        Vote vote = new Vote();
        User user = repo.findUserById(userId);
        Candidates candidates = candidateRepo.findCandidatesById(candidateId);
        DatesOfVoting datesOfVoting = dates.findDatesOfVotingBydateOfVoting(d2);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAA" + candidates.toString());

        vote.setCandidates(candidates);
        vote.setDatesOfVoting(datesOfVoting);
        vote.setVoter(user);
        voteRepo.save(vote);

        return new ResponseEntity<>("alreadyVoted", HttpStatus.OK);
}
}
