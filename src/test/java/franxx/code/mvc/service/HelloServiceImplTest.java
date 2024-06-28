package franxx.code.mvc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloHai() {
        assertEquals("hello guest", helloService.hai(null));
        assertEquals("hello pacman", helloService.hai("pacman"));
    }
}