package franxx.code.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hai(String name) {
        return name == null ? "hello guest" : "hello " + name;
    }
}
