package co.edu.uptc.testsistdist.controller;

import co.edu.uptc.testsistdist.model.Person;
import co.edu.uptc.testsistdist.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final PersonService personService;
    @GetMapping("/")
    public Person getRandomPerson(){
        return personService.getRandomPerson();
    }
}
