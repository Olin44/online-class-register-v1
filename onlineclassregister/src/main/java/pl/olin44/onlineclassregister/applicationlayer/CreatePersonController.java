package pl.olin44.onlineclassregister.applicationlayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.olin44.onlineclassregister.logic.CreatePersonService;

@Controller
public class CreatePersonController {

    private final CreatePersonService createPersonService;

    public CreatePersonController(CreatePersonService createPersonService) {
        this.createPersonService = createPersonService;
    }

    @PostMapping(value = "/students")
    public ResponseEntity<String> createPerson(@RequestBody CreatePersonCommand createPersonCommand) {
        createPersonService.create(createPersonCommand);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Person created");
    }
}
