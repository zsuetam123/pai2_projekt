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
public class RegisterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldregis() throws Exception{

        mockMvc.perform(
                post("/regis")
                        .param("Imie", "Imie")
                        .param("Nazwisko", "Nazwisko")
                        .param("Pesel", "12323434546")
                        .param("Miejscowosc", "Miejscowosc")
                        .param("Email", "Email")
                        .param("Login", "Login")
                        .param("Haslo", "Haslo"))
                .andDo(print()).andExpect(status().is(200));
    }

}
