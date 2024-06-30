package franxx.code.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import franxx.code.mvc.model.CreatePersonRequest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void createPerson() {
        CreatePersonRequest request = CreatePersonRequest.of(
                "mee",
                "mail@me.com",
                "0101",
                CreatePersonRequest.Address.of("bogor", "id"),
                List.of("kodng", "mkn"),
                List.of(
                        CreatePersonRequest.SocialMedia.of("fb", "fb.com"),
                        CreatePersonRequest.SocialMedia.of("ig", "ig.com")
                )
        );

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().json(jsonRequest)
        );
    }

    @Test
    @SneakyThrows
    void createPersonValidation() {
        CreatePersonRequest request = CreatePersonRequest.of(
                "",
                "",
                "0101",
                CreatePersonRequest.Address.of("bogor", "id"),
                List.of("kodng", "mkn"),
                List.of(
                        CreatePersonRequest.SocialMedia.of("fb", "fb.com"),
                        CreatePersonRequest.SocialMedia.of("ig", "ig.com")
                )
        );

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest()
        );
    }

}