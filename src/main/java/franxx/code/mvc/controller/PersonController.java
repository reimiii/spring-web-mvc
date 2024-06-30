package franxx.code.mvc.controller;

import franxx.code.mvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class PersonController {

  @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request, BindingResult bindingResult) {
    List<FieldError> allErrors = bindingResult.getFieldErrors();

    if (!allErrors.isEmpty()) {
      allErrors.forEach(e -> {
        System.out.println(
              e.getField() + ": " + e.getDefaultMessage()
        );
      });

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid data..");
    }

    System.out.println(request);

    String formatResponse = String.format("create person: %s %s %s, with address: %s %s", request.getUsername(), request.getEmail(), request.getPhone(), request.getAddress().getCity(), request.getAddress().getCounty());

    return ResponseEntity.ok(formatResponse);
  }
}
