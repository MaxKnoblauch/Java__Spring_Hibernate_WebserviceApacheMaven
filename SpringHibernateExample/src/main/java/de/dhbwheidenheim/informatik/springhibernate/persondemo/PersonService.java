package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
    
    public void makeMariage(int idFrom, int idTo, PersonRepository personRepository, HeiratRepository heiratRepository) {
    	System.out.println("User: " + idFrom + " soll verheiratet werden mit: " + idTo);
		System.out.println("Person from: " + personRepository.findById( Integer.valueOf(idFrom)) );
		System.out.println("Person to: " + personRepository.findById( Integer.valueOf(idTo)) );
	    Optional<Person> po1 = personRepository.findById( Integer.valueOf(idFrom)); // Optionals können Objekte oder auch nix enthalten. 
		Person p1 = po1.get();
		System.out.println("Personenobjekt (from) p1: " + p1);
		Optional<Person> po2 = personRepository.findById( Integer.valueOf(idTo));
		Person p2 = po2.get();
		System.out.println("Personenobjekt (to) p2: " + p2);
		/* Das Folgende funktioniert prinzipiell, hat aber den Nachteil, dass bei JSON-Ausgaben von Personen-Objekten Endlosschleifen entstehen.
		 * p1.verheirateMit(p2);
		 * personRepository.save(p1);
		 * personRepository.save(p2);
		 */
		Heirat h = new Heirat(p1, p2);  // ...ist besser...
		heiratRepository.save(h);
    }
    
    public Optional<Person> getPerson(int id, PersonRepository personRepository) {
    	System.out.println("Hole Person mit der ID " + id + " aus der DB");
    	return(personRepository.findById(id));
    }
    public long countPersons(PersonRepository personRepository) {
    	System.out.println("Ermittle die Anzahl der Personen auf der DB: ");
    	return(personRepository.count());
    }
    
}