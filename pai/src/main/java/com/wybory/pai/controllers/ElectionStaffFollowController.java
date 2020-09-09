package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionProgram;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ElectionStaffFollowController {

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    LoginRepo loginRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getFavCandidateInfo")
    ResponseEntity<List> getFavCandidateInfoOdp(@RequestParam("id") Long id){

        Candidates candidate = candidateRepo.findCandidatesById(id);

        List<User> usersFavCandidateInfo = loginRepo.findAllByFavCandidate(candidate);

        return new ResponseEntity<>(usersFavCandidateInfo, HttpStatus.OK);
    }

}
