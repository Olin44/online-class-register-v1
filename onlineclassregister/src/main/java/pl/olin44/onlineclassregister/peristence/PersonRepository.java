package pl.olin44.onlineclassregister.peristence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.olin44.onlineclassregister.domain.Gender;
import pl.olin44.onlineclassregister.peristence.PersonEntity;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByFirstNameAndSecondNameAndSurnameAndBirthDateAndGenderAndPhoneNumberAndEmail(String firstName,
                                                                                                             String secondName,
                                                                                                             String surname,
                                                                                                             LocalDate birthDate,
                                                                                                             Gender gender,
                                                                                                             String phoneNumber,
                                                                                                             String email);
}
