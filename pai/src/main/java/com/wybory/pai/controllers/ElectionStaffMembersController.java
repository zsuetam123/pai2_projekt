package com.wybory.pai.controllers;

import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.models.ElectionStaffMembers;
import com.wybory.pai.repository.ElectionStaffMembersRepo;
import com.wybory.pai.repository.ElectionStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElectionStaffMembersController {
    @Autowired
    private ElectionStaffMembersRepo electionStaffMembersRepo;
/*
    @RequestMapping("/getElectionStaffMembers")
    public List<ElectionStaffMembers> getElectionStaffMembers() {
        return electionStaffMembersRepo.findAll();
    }

    @PostMapping("/newElectionStaffMembers")
    public String newElectionStaffMembers(@RequestBody ElectionStaffMembers electionStaffMembers){
        electionStaffMembersRepo.save(electionStaffMembers);
        return electionStaffMembers.toString();
    }
 */



}
