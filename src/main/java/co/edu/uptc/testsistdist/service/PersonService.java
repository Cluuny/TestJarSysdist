package co.edu.uptc.testsistdist.service;

import co.edu.uptc.testsistdist.model.Person;
import co.edu.uptc.testsistdist.model.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonService {
    @Autowired
    private JsonService jsonService;

    public Person getRandomPerson() {
        Root root = jsonService.getPeoplerFromJson();
        Random random = new Random();
        String name = root.personas.nombres.get(this.getRandomNumber(random));
        String lastName = root.personas.apellidos.get(this.getRandomNumber(random));
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        return person;
    }

    public int getRandomNumber(Random random) {
        return random.nextInt(100);
    }

}
