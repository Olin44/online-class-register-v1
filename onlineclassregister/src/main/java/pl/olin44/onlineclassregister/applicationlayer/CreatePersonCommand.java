package pl.olin44.onlineclassregister.applicationlayer;

import pl.olin44.onlineclassregister.applicationlayer.validation.date.ValidBirthDate;
import pl.olin44.onlineclassregister.applicationlayer.validation.email.ValidEmail;
import pl.olin44.onlineclassregister.applicationlayer.validation.phone.ValidPhoneNumber;
import pl.olin44.onlineclassregister.applicationlayer.validation.text.ValidString;
import pl.olin44.onlineclassregister.applicationlayer.validation.text.optional.ValidOptionalString;

public record CreatePersonCommand(@ValidString String firstName,
                                  @ValidOptionalString String secondName,
                                  @ValidString String surname,
                                  @ValidBirthDate String birthDate,
                                  @ValidString String gender,
                                  @ValidPhoneNumber String phoneNumber,
                                  @ValidEmail String email) {
}


