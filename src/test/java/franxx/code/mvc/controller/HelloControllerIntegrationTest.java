package franxx.code.mvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    private static String url = "http://localhost:";

    @LocalServerPort
    private String serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloGuest() {
        ResponseEntity<String> forEntityResponse = restTemplate.getForEntity(url + serverPort + "/hello", String.class);
        String body = forEntityResponse.getBody();
        System.out.println(body);
        assertNotNull(body);
        assertEquals("hello guest", body.trim());
    }

    @Test
    void helloMee() {
        ResponseEntity<String> forEntityResponse = restTemplate.getForEntity(url + serverPort + "/hello?name=mee", String.class);
        String body = forEntityResponse.getBody();
        System.out.println(body);
        assertNotNull(body);
        assertEquals("hello mee", body.trim());
    }
}
