package franxx.code.mvc.servlet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloServletTest {

  @LocalServerPort
  private Integer port;

  @Autowired
  private RestTemplate restTemplate;

  @Test
  void servlet() {
    String forObject = restTemplate.getForObject("http://localhost:" + port + "/s/v", String.class);
    assertNotNull(forObject);
    assertEquals("ugh", forObject.trim());
  }
}