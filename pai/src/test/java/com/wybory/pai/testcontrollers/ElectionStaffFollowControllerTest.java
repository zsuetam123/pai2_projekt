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
public class ElectionStaffFollowControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    LoginRepo repo;

    @Test
    void shouldgetFavCandidateInfo() throws Exception{
        User user = repo.findUserByAdressEmail("Email");
        mockMvc.perform(
                post("/getFavCandidateInfo")
                        .param("id", user.getId().toString()))
                .andDo(print()).andExpect(status().is(200));
    }

}
