package com.wybory.pai.testcontrollers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
public class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetVotingInfo() throws Exception{

        mockMvc.perform(
                post("/getVotingInfo"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    void shouldGetCandidatesInfo() throws Exception{

        mockMvc.perform(
                post("/getCandidatesInfo"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    void shouldGetElectionStaffMembersInfo() throws Exception{

        mockMvc.perform(
                post("/getElectionStaffMembersInfo"))
                .andDo(print()).andExpect(status().is(200));
    }

    @Test
    void shouldGetDatesOfVotingInfo() throws Exception{

        mockMvc.perform(
                post("/getDatesOfVotingInfo"))
                .andDo(print()).andExpect(status().is(200));
    }

}
