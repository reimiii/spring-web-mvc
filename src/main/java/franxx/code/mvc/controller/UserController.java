package franxx.code.mvc.controller;

import franxx.code.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

  @GetMapping(path = "/user/current")
  @ResponseBody
  public String getUser(@SessionAttribute(name = "user") User user) {
    return String.format("hello: %s", user.getUsername());
  }
}
