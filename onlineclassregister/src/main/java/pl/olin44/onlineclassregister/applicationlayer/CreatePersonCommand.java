package pl.olin44.onlineclassregister.applicationlayer;

public record CreatePersonCommand(String firstName, String secondName, String surname,
                                  String birthDate, String gender, String phoneNumber,
                                  String email) {}
