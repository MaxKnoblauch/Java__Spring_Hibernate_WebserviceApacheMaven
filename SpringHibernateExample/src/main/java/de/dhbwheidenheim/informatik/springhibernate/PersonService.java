package de.dhbwheidenheim.informatik.springhibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class PersonService {
   
	// Die Service-Klasse ist das Bindeglied zwischen Controller und Datenhaltung
	// Vorteil: Alle Daten, die von und zur DB gehen, kommen hier vorbei...

    public List<Person> retrievePersons(PersonRepository personRepository) {
    	System.out.println("Liste aus der DB: " + personRepository.findAll());
        return (List<Person>) personRepository.findAll();
    }
    public void addPerson(Person p, PersonRepository personRepository) {
    	System.out.println("Speichere in DB: " + p);
    	personRepository.save(p);
    }
    public long countPersons(PersonRepository personRepository) {
    	System.out.println("Ermittle die Anzahl der Personen auf der DB: ");
    	return(personRepository.count());
    }
    
}