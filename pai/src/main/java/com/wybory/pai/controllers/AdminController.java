package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.ElectionStaffMembers;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.DatesOfVotingRepo;
import com.wybory.pai.repository.ElectionStaffMembersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    DatesOfVotingRepo datesRepo;

    @Autowired
    CandidateRepo candidatesRepo;

    @Autowired
    ElectionStaffMembersRepo membersRepo;

    @Autowired
    DatesOfVotingRepo datesOfVotingRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getVotingInfo")
    ResponseEntity<String[][]> candidatesOdp(){

        List<DatesOfVoting> datesOfVotingList = datesRepo.findAll();

        String[][] stringArray = new String[datesOfVotingList.size()][2];

        for(int size = datesOfVotingList.size(); size > 0; size--){

            stringArray[size-1][0] = datesOfVotingList.get(size - 1).getId().toString();
            stringArray[size-1][1] = datesOfVotingList.get(size - 1).getDateOfVoting().toString();
        }

        return new ResponseEntity<>(stringArray, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getCandidatesInfo")
    ResponseEntity<List> candidatesInfoOdp(){

        List<Candidates> candidatesList = candidatesRepo.findAll();

        return new ResponseEntity<>(candidatesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getElectionStaffMembersInfo")
    ResponseEntity<List> electionStaffMembersInfoOdp(){

        List<ElectionStaffMembers> membersList = membersRepo.findAll();

        return new ResponseEntity<>(membersList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getDatesOfVotingInfo")
    ResponseEntity<List> datesOfVotingInfoOdp(){

        List<DatesOfVoting> datesOfVotingList = datesOfVotingRepo.findAll();

        return new ResponseEntity<>(datesOfVotingList, HttpStatus.OK);
    }

}
