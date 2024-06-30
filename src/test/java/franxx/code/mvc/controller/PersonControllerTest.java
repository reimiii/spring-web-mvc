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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "me")
                        .param("email", "mail@me")
                        .param("phone", "0000")
                        .param("address.city", "bogor")
                        .param("address.county", "indo")
                        .param("hobbies[0]", "makan")
                        .param("hobbies[1]", "ngoding")
                        .param("socialMedia[0].name", "fb")
                        .param("socialMedia[0].url", "www")
                        .param("socialMedia[1].name", "ig")
                        .param("socialMedia[1].url", "wwwig")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString(
                        "create person: me mail@me 0000, with address: bogor indo"
                ))
        );
    }

    @Test
    void createValidation() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("email", "mail@me")
                        .param("phone", "0000")
                        .param("address.city", "bogor")
                        .param("address.county", "indo")
                        .param("hobbies[0]", "makan")
                        .param("hobbies[1]", "ngoding")
                        .param("socialMedia[0].name", "fb")
                        .param("socialMedia[0].url", "www")
                        .param("socialMedia[1].name", "ig")
                        .param("socialMedia[1].url", "wwwig")
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}