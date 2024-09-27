package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Person hinzufügen
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    // Alle Personen abrufen
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Person nach ID finden
    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    // Anzahl der Personen zählen
    public long countPersons() {
        return personRepository.count();
    }
}
