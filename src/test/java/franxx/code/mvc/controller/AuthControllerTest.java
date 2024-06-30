package franxx.code.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void success() throws Exception {
       mockMvc.perform(
               post("/auth/login")
                       .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                       .param("username", "me")
                       .param("password", "me")
       ).andExpectAll(
               status().isOk(),
               content().string(Matchers.containsString("OK"))
       );
    }

    @Test
    void fail() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "salah")
                        .param("password", "salah")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("KO"))
        );
    }

}