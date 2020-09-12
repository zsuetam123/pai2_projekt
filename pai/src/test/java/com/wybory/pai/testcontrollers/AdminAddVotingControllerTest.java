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
public class AdminAddVotingControllerTest {

    @Autowired
    MockMvc mockMvc;

@Test
    void shouldAddVotingDate() throws Exception{

    mockMvc.perform(
            post("/addVotingDate")
            .param("data", "2019-09-11 00:00:00"))
            .andDo(print()).andExpect(status().is(200));
}

    @Test
    void shouldDeleteVotingDate() throws Exception{

        mockMvc.perform(
                post("/deleteVotingDate")
                        .param("dayId", "232"))
                .andDo(print()).andExpect(status().is(200));
    }

}
