package com.wybory.pai.controllers;

import com.wybory.pai.models.ElectionProgram;
import com.wybory.pai.repository.ElectionProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ElectionStaffDemands {

    @Autowired
    ElectionProgramRepo electionProgramRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("setDemandsInfo")
    ResponseEntity<ElectionProgram> setDemandsInfoOdp(@RequestParam("DemandsInfo") String demands, @RequestParam("DemandsId") Integer id){

        ElectionProgram electionProgram = electionProgramRepo.findElectionProgramById(id);
        electionProgram.setDemands(demands);
        electionProgram = electionProgramRepo.save(electionProgram);

        return new ResponseEntity<>(electionProgram, HttpStatus.OK);
    }

}
