package pl.olin44.onlineclassregister.logic;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.olin44.onlineclassregister.applicationlayer.CreatePersonCommand;
import pl.olin44.onlineclassregister.domain.Person;
import pl.olin44.onlineclassregister.peristence.PersonEntity;
import pl.olin44.onlineclassregister.peristence.PersonRepository;

@Service
public class CreatePersonService {

    private final PersonRepository personRepository;

    public CreatePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void create(CreatePersonCommand createPersonCommand){
        Person person = toDomain(createPersonCommand);
        PersonEntity personEntity = toEntity(person);
        if (isNotUniquePerson(personEntity)) {
            throw new IllegalArgumentException("Person with that data already exist");
        }
        personRepository.save(personEntity);
    }

    private PersonEntity toEntity(Person person) {
        return new PersonEntity(person.getFirstName(),
                person.getSecondName(),
                person.getSurname(),
                person.getBirthDate().getBirthDate(),
                person.getGender(),
                person.getPhoneNumber().getPhoneNumber(),
                person.getEmail().getEmail()
                );
    }

    private Person toDomain(CreatePersonCommand createPersonCommand) {
        return new Person(createPersonCommand.firstName(),
                createPersonCommand.secondName(),
                createPersonCommand.surname(),
                createPersonCommand.birthDate(),
                createPersonCommand.gender(),
                createPersonCommand.phoneNumber(),
                createPersonCommand.email());
    }

    private boolean isNotUniquePerson(PersonEntity personEntity) {
        return personRepository.findOne(Example.of(personEntity))
                .isPresent();
    }
}
