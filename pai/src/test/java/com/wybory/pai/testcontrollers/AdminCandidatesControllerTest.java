package com.wybory.pai.testcontrollers;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.CandidateRepo;
import com.wybory.pai.repository.ElectionStaffRepo;
import com.wybory.pai.repository.LoginRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminCandidatesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CandidateRepo candidateRepo;


    @Test
    @Order(1)
    void shouldAddCandidate() throws Exception{

        mockMvc.perform(
                post("/addCandidate")
                        .param("CandidateName", "Michal")
                        .param("CandidateSurname", "Worek"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Autowired
    LoginRepo repo;

    @Autowired
    ElectionStaffRepo staffRepo;

    @Test
    @Order(2)
    void shouldaddfavcandidate() throws Exception{

        User user = repo.findUserByAdressEmail("Email");
        Candidates candidates = candidateRepo.findCandidatesByNameAndSurname("Michal", "Worek");
        ElectionStaff electionStaff = staffRepo.findElectionStaffByCandidates(candidates);

                mockMvc.perform(
                post("/addfavcandidate")
                        .param("candidateId", electionStaff.getId().toString())
                        .param("userId", user.getId().toString()))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    @Order(3)
    void shouldAddVotingDate() throws Exception{

        User user = repo.findUserByAdressEmail("Email");
        Candidates candidates = candidateRepo.findCandidatesByNameAndSurname("Michal", "Worek");

        mockMvc.perform(
                post("/vote")
                        .param("candidateId", candidates.getId().toString())
                        .param("userId", user.getId().toString())
                        .param("dateOfVoting", "2019-09-11 00:00:00"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    @Order(4)
    void shouldEditCandidate() throws Exception{

        Candidates CandidateToDelete = candidateRepo.findCandidatesByNameAndSurname("Michal", "Worek");

        mockMvc.perform(
                post("/editCandidate")
                        .param("candidateId", CandidateToDelete.getId().toString())
                        .param("CandidateName", "Michal")
                        .param("CandidateSurname", "Worek"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    @Order(5)
    void shouldDeleteCandidate() throws Exception{

        Candidates CandidateToDelete = candidateRepo.findCandidatesByNameAndSurname("Michal", "Worek");

        mockMvc.perform(
                post("/deleteCandidate")
                        .param("candidateId", CandidateToDelete.getId().toString()))
                .andDo(print()).andExpect(status().is(200));
    }



}
