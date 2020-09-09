package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionProgram;
import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.ElectionProgramRepo;
import com.wybory.pai.repository.ElectionStaffRepo;
import com.wybory.pai.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCandidateController {

    @Autowired
    LoginRepo repo;

    @Autowired
    ElectionProgramRepo electionRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    ElectionStaffRepo staffRepo;

    String[] newFav = new String[2];

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/addfavcandidate")
    ResponseEntity<String[]> candidatesOdp(@RequestParam("candidateId") Integer candidateId, @RequestParam("userId") Long userId){

        User user = repo.findUserById(userId);

        ElectionStaff electionStaff = staffRepo.findElectionStaffById(candidateId);

        Candidates candidates = candidateRepo.findCandidatesById(electionStaff.getCandidates().getId());

        ElectionProgram electionProgram = electionRepo.findElectionProgramByElectionStaffId(electionStaff.getId());

        user.setfavCandidate(candidates);

        repo.save(user);

        if(electionProgram.getDemands() != null){

        newFav[0] = electionProgram.getDemands();
            }
        else{
            newFav[0] = "";
        }

        newFav[1] = candidates.toString();

        return new ResponseEntity<>(newFav, HttpStatus.OK);
    }
}
