package com.wybory.pai.controllers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionProgram;
import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.models.ElectionStaffMembers;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.ElectionProgramRepo;
import com.wybory.pai.repository.ElectionStaffMembersRepo;
import com.wybory.pai.repository.ElectionStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElectionStaffController {
    @Autowired
    private ElectionStaffRepo electionStaffRepo;

    @Autowired
    ElectionStaffMembersRepo electionStaffMembersRepo;

    @Autowired
    ElectionProgramRepo electionProgramRepo;
/*
    @RequestMapping("/getElectionStaff")
    public List<ElectionStaff> getElectionStaff() {
        return electionStaffRepo.findAll();
    }

    @PostMapping("/newElectionStaff")
    public String newElectionStaff(@RequestBody ElectionStaff electionStaff){
        electionStaffRepo.save(electionStaff);
        return electionStaff.toString();
    }
    */

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("getDemandsInfo")
    ResponseEntity<ElectionProgram> getDemandsInfoOdp(@RequestParam ("id") Integer id){

        ElectionProgram electionProgram = electionProgramRepo.findElectionProgramByElectionStaffId(id);

        return new ResponseEntity<>(electionProgram, HttpStatus.OK);
    }


}
