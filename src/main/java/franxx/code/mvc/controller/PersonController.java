package franxx.code.mvc.controller;

import franxx.code.mvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createPerson(@ModelAttribute CreatePersonRequest request) {
        System.out.println(request);

        return String.format(
                "create person: %s %s %s, with address: %s %s",
                request.getUsername(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress().getCity(),
                request.getAddress().getCounty()
        );
    }
}
