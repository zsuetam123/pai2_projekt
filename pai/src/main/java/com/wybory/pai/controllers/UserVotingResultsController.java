package com.wybory.pai.controllers;

import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.VotingResults;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.DatesOfVotingRepo;
import com.wybory.pai.repository.VoteRepo;
import com.wybory.pai.repository.VotingResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserVotingResultsController {

    @Autowired
    DatesOfVotingRepo datesOfVotingRepo;

    @Autowired
    VotingResultsRepo votingResultsRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getVotingResultsForUser")
    ResponseEntity<List> getVotingResultsForUserOdp(@RequestParam("VotingId") Integer VotingId){

        DatesOfVoting searchedDateOfVoting = datesOfVotingRepo.findDatesOfVotingById(VotingId);
        List<VotingResults> finalResults = votingResultsRepo.findAllByDateOfVoting(searchedDateOfVoting);
        return new ResponseEntity<>(finalResults, HttpStatus.OK);
    }

}
