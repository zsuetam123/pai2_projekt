package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.ElectionStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElectionStaffController {
    @Autowired
    private ElectionStaffRepo electionStaffRepo;

    @RequestMapping("/getElectionStaff")
    public List<ElectionStaff> getElectionStaff() {
        return electionStaffRepo.findAll();
    }

    @PostMapping("/newElectionStaff")
    public String newElectionStaff(@RequestBody ElectionStaff electionStaff){
        electionStaffRepo.save(electionStaff);
        return electionStaff.toString();
    }
}
