package com.wybory.pai.controllers;

import com.wybory.pai.models.*;
import com.wybory.pai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCandidatesController {

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    ElectionStaffRepo electionStaffRepo;

    @Autowired
    ElectionProgramRepo electionProgramRepo;

    @Autowired
    ElectionStaffMembersRepo electionStaffMembersRepo;

    @Autowired
    LoginRepo loginRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("addCandidate")
    ResponseEntity<String> adminAddCandidateOdp(@RequestParam("CandidateName") String CandidateName, @RequestParam("CandidateSurname") String CandidateSurname){

        Candidates newCandidate = new Candidates();

        if(candidateRepo.findCandidatesByNameAndSurname(CandidateName, CandidateSurname) == null){
            newCandidate.setName(CandidateName);
            newCandidate.setSurname(CandidateSurname);

            ElectionStaff newStaff = new ElectionStaff();
            newStaff.setCandidates(candidateRepo.save(newCandidate));

            ElectionProgram newProgram = new ElectionProgram();
            newProgram.setElectionStaff(electionStaffRepo.save(newStaff));
           // newProgram.setDemands("a");
            electionProgramRepo.save(newProgram);

            return new ResponseEntity<>("Dodano kandydata", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Kandydat już istnieje", HttpStatus.OK);
        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("editCandidate")
    ResponseEntity<String> adminEditCandidateOdp(@RequestParam("candidateId") Long candidateId, @RequestParam("CandidateName") String CandidateName, @RequestParam("CandidateSurname") String CandidateSurname){

        Candidates CandidateToUpdate = candidateRepo.findCandidatesById(candidateId);

        if(CandidateToUpdate != null){
            CandidateToUpdate.setName(CandidateName);
            CandidateToUpdate.setSurname(CandidateSurname);
            candidateRepo.save(CandidateToUpdate);
            return new ResponseEntity<>("Zmodyfikowano kandydata", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Błąd podczas modyfikowania kandydata", HttpStatus.OK);
        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("deleteCandidate")
    ResponseEntity<String> deleteCandidateOdp(@RequestParam("candidateId") Long candidateId){

        Candidates CandidateToDelete = candidateRepo.findCandidatesById(candidateId);

        User userFavCandidateToDelete = loginRepo.findUserByFavCandidate(CandidateToDelete);

        ElectionStaff StaffToDelete = electionStaffRepo.findElectionStaffByCandidates(CandidateToDelete);

        ElectionStaffMembers MembersToDelete = electionStaffMembersRepo.findElectionStaffMembersByElectionStaff(StaffToDelete);

        ElectionProgram ProgramToDelete = electionProgramRepo.findElectionProgramByElectionStaffId(StaffToDelete.getId());

        if(ProgramToDelete != null){
            electionProgramRepo.delete(ProgramToDelete);
            while(MembersToDelete != null){
                electionStaffMembersRepo.delete(MembersToDelete);
                MembersToDelete = electionStaffMembersRepo.findElectionStaffMembersByElectionStaff(StaffToDelete);
            }
            while(userFavCandidateToDelete != null){
                userFavCandidateToDelete.setfavCandidate(null);
                loginRepo.save(userFavCandidateToDelete);
                userFavCandidateToDelete = loginRepo.findUserByFavCandidate(CandidateToDelete);
            }
            electionStaffRepo.delete(StaffToDelete);

            candidateRepo.delete(CandidateToDelete);
            return new ResponseEntity<>("Usunięto kandydata", HttpStatus.OK); }
        else{
            return new ResponseEntity<>("Błąd podczas usuwania kandydata", HttpStatus.OK);
        }

    }

}
