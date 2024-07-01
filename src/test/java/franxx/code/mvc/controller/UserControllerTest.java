package franxx.code.mvc.controller;

import franxx.code.mvc.model.User;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @SneakyThrows
  void getUser() {
    mockMvc.perform(
          get("/user/current")
                .sessionAttr("user", User.of("me"))
    ).andExpectAll(
          status().isOk(),
          content().string(Matchers.containsString("hello: me"))
    );
  }

  @Test
  @SneakyThrows
  void getUserInvalid() {
    mockMvc.perform(
          get("/user/current")
    ).andExpectAll(
          status().is3xxRedirection()
    );
  }
}