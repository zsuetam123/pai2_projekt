package com.wybory.pai.testcontrollers;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.LoginRepo;
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
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    LoginRepo repo;

    @Test
    void shouldCandidates() throws Exception{

        mockMvc.perform(
                post("/candidates"))
                .andDo(print()).andExpect(status().is(200));
    }


    @Test
    void shouldvotingcheck() throws Exception{
        User user = repo.findUserByAdressEmail("Email");
        mockMvc.perform(
                post("/votingcheck")
                        .param("userId", user.getId().toString() )
                        .param("dateOfVoting", "2019-09-11 00:00:00"))
                .andDo(print()).andExpect(status().is(200));
    }


}
