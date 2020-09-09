package com.wybory.pai.controllers;

import com.wybory.pai.models.*;
import com.wybory.pai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    LoginRepo repo;

    @Autowired
    DatesOfVotingRepo dates;

    @Autowired
    ElectionProgramRepo electionRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    ElectionStaffRepo staffRepo;

    @Autowired
    ElectionStaffMembersRepo electionStaffMembersRepo;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("login")
    ResponseEntity<String []> loginOdp(@RequestParam ("email") String email,
                                    @RequestParam ("haslo") String haslo) throws ParseException {

        User user = repo.findUserByAdressEmail(email);

        if (user != null) {

            switch (user.getPermission().toString()){
                case "user":
                    return new ResponseEntity<>(userLog(user, haslo), HttpStatus.OK);
                case "admin":
                    return new ResponseEntity<>(adminLog(user, haslo), HttpStatus.OK);
                case "electionstaff":
                    return new ResponseEntity<>(electionstaffLog(user, haslo), HttpStatus.OK);
                default:
                    return new ResponseEntity<>(userLog(user, haslo), HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(userLog(user, haslo), HttpStatus.OK);
        }
    }

    String[] electionstaffLog(User user, String haslo){

        String[] electionstaffInfo = new String[8];

        ElectionStaffMembers electionStaffMembers = electionStaffMembersRepo.findElectionStaffMembersByNameAndSurname(user.getName(), user.getSurname());

        if (haslo.equals(user.getPassword()))
        {
            electionstaffInfo[0] = user.getId().toString();
            electionstaffInfo[1] = electionStaffMembers.getElectionStaff().getId().toString();
            electionstaffInfo[3] = "Ok";
            electionstaffInfo[7] = user.getPermission().toString();
            return electionstaffInfo;
        }else{
            electionstaffInfo[3] = "Złe haslo";
            electionstaffInfo[7] = user.getPermission().toString();
            return electionstaffInfo;
        }
    }

    String[] adminLog(User user, String haslo){

        String[] adminInfo = new String[8];

        if (haslo.equals(user.getPassword()))
        {
            adminInfo[3] = "Ok";
            adminInfo[7] = user.getPermission().toString();
            return adminInfo;
        }else{
            adminInfo[3] = "Złe haslo";
            adminInfo[7] = user.getPermission().toString();
            return adminInfo;
        }
    }

    String[] userLog(User user, String haslo) throws ParseException{

        String[] userInfo = new String[8];

        if (haslo.equals(user.getPassword()))
        {
            userInfo[0] = user.getId().toString();
            userInfo[3] = "Ok";
            datescomparator(userInfo);
            userInfo[6] = "able";
            userInfo[7] = user.getPermission().toString();
            if(user.getfavCandidate() != null){
               // ElectionProgram program = electionRepo.findElectionProgramById(user.getfavCandidate());

                ElectionStaff electionStaff = staffRepo.findElectionStaffByCandidates(user.getfavCandidate());
                if(electionStaff != null){
                    ElectionProgram electionProgram = electionRepo.findElectionProgramByElectionStaffId(electionStaff.getId());

                    userInfo[2] = electionProgram.getDemands();

                    //userInfo[2] = program.getDemands();

                    Candidates candidate = candidateRepo.findCandidatesById(user.getfavCandidate().getId());
                    userInfo[5] = candidate.toString();
                }else{
                    userInfo[2] = "";
                    userInfo[5] = "Brak ulubionego kandydata";
                }
}
            else{
                userInfo[2] = "";
                userInfo[5] = "Brak ulubionego kandydata";
            }

            return userInfo;

        }else{
            userInfo[0] = "null";
            userInfo[1] = "null";
            userInfo[2] = "null";
            userInfo[3] = "Złe haslo";
            userInfo[4] = "null";
            userInfo[5] = "null";
            userInfo[6] = "null";
            userInfo[7] = "null";
            return userInfo;
        }
    }

    String[] datescomparator(String[] userInfo) throws ParseException {

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");
        SimpleDateFormat formatter3 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        String d3 = new Date().toString();
        Date d2 = formatter3.parse(d3);
        d3 = formatter2.format(d2);
        d2 = formatter2.parse(d3);

        String voting;

        if(dates.findDatesOfVotingBydateOfVoting(d2) == null){
            userInfo[1] = "";
            userInfo[4] = "nie jest obecnie aktywne";
            return userInfo;
        }

        voting = dates.findDatesOfVotingBydateOfVoting(d2).getDateOfVoting().toString();
        Date d1 = formatter1.parse(voting);
        d3= formatter1.format(d2);

      if(d1.compareTo(d2) > 0) {
          userInfo[1] = d3;
          userInfo[4] = "odbędzie się:";
         return userInfo;
      } else if(d1.compareTo(d2) < 0) {
          userInfo[1] = d3;
          userInfo[4] = "odbyło się:";
          return userInfo;
      } else if(d1.compareTo(d2) == 0) {
          userInfo[1] = d3;
          userInfo[4] = "odbedzie sie dzis:";
          return userInfo;
      }
        userInfo[4] = "Błąd daty";
      return userInfo;
    }
}
