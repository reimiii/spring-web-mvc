package franxx.code.mvc.controller;

import franxx.code.mvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class HelloController {

  @Autowired
  private HelloService helloService;

  @GetMapping(path = "/hello")
  public void helloWorld(@RequestParam(name = "name", required = false) String name,
                         HttpServletResponse response) throws IOException {
    String hai = helloService.hai(name);
    response.getWriter().println(hai);
  }

  @GetMapping(path = "/web/hello")
  public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
    return new ModelAndView("hello", Map.of(
          "title", "learn view",
          "name", name
    ));
  }
}
