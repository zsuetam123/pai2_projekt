package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.Vote;
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
public class AdminVotingResultsController {

    @Autowired
    DatesOfVotingRepo datesOfVotingRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    VoteRepo voteRepo;

    @Autowired
    VotingResultsRepo votingResultsRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getVotingResults")
    ResponseEntity<List> getVotingResultsOdp(@RequestParam("VotingId") Integer VotingId){

        DatesOfVoting searchedDateOfVoting = datesOfVotingRepo.findDatesOfVotingById(VotingId);

        List<VotingResults> votingResults = votingResultsRepo.findVotingResultsByDateOfVoting(searchedDateOfVoting);

        int candidateListLength;
        int candidateResultLength;

        if(votingResults == null){

        List<Candidates> candidatesList = candidateRepo.findAll();
        candidateListLength = candidatesList.size();

        for(int i = 0; i < candidateListLength; i++){
            VotingResults votingResults1 = new VotingResults();
            List<Vote> candidateResult = voteRepo.findAllByCandidatesAndDatesOfVoting(candidatesList.get(i),searchedDateOfVoting);
            candidateResultLength = candidateResult.size();
            votingResults1.setCandidates(candidatesList.get(i));
            votingResults1.setNumberOfVotes(candidateResultLength);
            votingResults1.setDateOfVoting(searchedDateOfVoting);
            votingResultsRepo.save(votingResults1);
        }

        List<VotingResults> finalResults = votingResultsRepo.findAllByDateOfVoting(searchedDateOfVoting);

        return new ResponseEntity<>(finalResults, HttpStatus.OK);
    }else{
            List<VotingResults> finalResults = votingResultsRepo.findAllByDateOfVoting(searchedDateOfVoting);
            return new ResponseEntity<>(finalResults, HttpStatus.OK);
        }
    }

}
