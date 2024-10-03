package de.dhbwheidenheim.informatik.springhibernate.persondemo;




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

   
}
