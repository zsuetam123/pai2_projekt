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
public class AdminElectionStaffController {

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    ElectionStaffRepo electionStaffRepo;

    @Autowired
    ElectionStaffMembersRepo electionStaffMembersRepo;

    @Autowired
    LoginRepo userRepo;

    @Autowired
    PermissionRepo permissionRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("addMember")
    ResponseEntity<String> adminAddMemberOdp(@RequestParam("MemberName") String MemberName, @RequestParam("MemberSurname") String MemberSurname, @RequestParam("selected") Long selected, @RequestParam("position") String position){

        ElectionStaffMembers newMember = new ElectionStaffMembers();
        Candidates memberCandidate = candidateRepo.findCandidatesById(selected);
        ElectionStaff candidateStaff = electionStaffRepo.findElectionStaffByCandidates(memberCandidate);
        User memberUser = userRepo.findUserByNameAndSurname(MemberName, MemberSurname);
        Permission memberPermission = permissionRepo.findPermissionById(2);

        if(electionStaffMembersRepo.findElectionStaffMembersByNameAndSurname(MemberName, MemberSurname) == null && memberUser != null){
            newMember.setName(MemberName);
            newMember.setSurname(MemberSurname);
            newMember.setPosition(position);
            newMember.setElectionStaff(candidateStaff);
            memberUser.setPermission(memberPermission);
            userRepo.save(memberUser);
            electionStaffMembersRepo.save(newMember);
            return new ResponseEntity<>("Dodano czlonka", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Czlonek juz istnieje lub nie ma takiego użytkownika", HttpStatus.OK);
        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("deleteMember")
    ResponseEntity<String> deleteCandidateOdp(@RequestParam("memberId") Long memberId){

        ElectionStaffMembers memberToDelete = electionStaffMembersRepo.findElectionStaffMembersById(memberId);
        if(memberToDelete != null){
            electionStaffMembersRepo.delete(memberToDelete);
            return new ResponseEntity<>("Usunięto członka", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Błąd podczas usuwania członka", HttpStatus.OK);
        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("editMember")
    ResponseEntity<String> adminEditMemberOdp(@RequestParam("MemberId") Long MemberId, @RequestParam("editMemberName") String editMemberName, @RequestParam("editMemberSurname") String editMemberSurname, @RequestParam("editSelected") Long editSelected, @RequestParam("editPosition") String editPosition){

        ElectionStaffMembers memberToEdit = electionStaffMembersRepo.findElectionStaffMembersById(MemberId);
        Candidates memberCandidate = candidateRepo.findCandidatesById(editSelected);
        ElectionStaff candidateStaff = electionStaffRepo.findElectionStaffByCandidates(memberCandidate);
        if(memberToEdit != null){
            memberToEdit.setName(editMemberName);
            memberToEdit.setSurname(editMemberSurname);
            memberToEdit.setPosition(editPosition);
            memberToEdit.setElectionStaff(candidateStaff);
            electionStaffMembersRepo.save(memberToEdit);
            return new ResponseEntity<>("Zmodyfikowano członka", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Błąd podczas modyfikowania członka", HttpStatus.OK);
        }
    }

}
