package franxx.code.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void helloGuest() throws Exception {
    mockMvc.perform(get("/hello"))
          .andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello guest"))
          );
  }

  @Test
  void helloMee() throws Exception {
    mockMvc.perform(get("/hello").queryParam("name", "Mee"))
          .andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello Mee"))
          );
  }

  @Test
  void methodPost() throws Exception {
    mockMvc.perform(post("/hello").queryParam("name", "Mee"))
          .andExpectAll(
                status().isMethodNotAllowed()
          );
  }

  @Test
  void getMustache() throws Exception {
    mockMvc.perform(get("/web/hello").queryParam("name", "Mee"))
          .andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello Mee")),
                content().string(Matchers.containsString("learn view"))
          );
  }

  @Test
  void getMustacheRedirect() throws Exception {
    mockMvc.perform(get("/web/hello"))
          .andExpectAll(
                status().is3xxRedirection()
          );
  }
}