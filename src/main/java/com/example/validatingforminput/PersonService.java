package com.example.validatingforminput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonFormRepository personRepository;

    @Autowired
    public PersonService(PersonFormRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(PersonForm personForm) {
        PersonForm person = new PersonForm();
        person.setName(personForm.getName());
        person.setEmail(personForm.getEmail());
        person.setPassword(personForm.getPassword());
        personRepository.save(person);
    }
}
