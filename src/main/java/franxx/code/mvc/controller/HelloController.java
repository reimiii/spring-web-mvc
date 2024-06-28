package franxx.code.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HelloController {

    @RequestMapping(path = "hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("name");
        if (Objects.isNull(parameter)) {
            parameter = "guest";
        }

        response.getWriter().println("hello " + parameter);
    }
}
