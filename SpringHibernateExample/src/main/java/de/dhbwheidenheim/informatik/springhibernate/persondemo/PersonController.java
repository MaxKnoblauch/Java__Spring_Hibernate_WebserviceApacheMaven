package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/persondemo") // Der URL-Pfad für Person-Demo-Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ReservierungRepository reservierungRepository;

    // Neue Person hinzufügen
    @GetMapping(path = "/addPerson")
    public @ResponseBody String addPerson(@RequestParam String name, @RequestParam String vorname, @RequestParam int age) {
        try {
            Person p = new Person(name, vorname, age);
            personService.addPerson(p);
            return "Person erfolgreich hinzugefügt!";
        } catch (Exception e) {
            return "Fehler: " + e.getMessage();
        }
    }

    // Alle Personen anzeigen
    @GetMapping(path = "/allPersons")
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // Eine Person mit allen ihren Reservierungen anzeigen
    @GetMapping(path = "/personWithReservations")
    public @ResponseBody String getPersonWithReservations(@RequestParam int personId) {
        Optional<Person> personOptional = personService.getPersonById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            StringBuilder response = new StringBuilder("Person: " + person.getName() + ", Reservierungen: ");
            
            for (Reservierung reservierung : person.getReservierungen()) {
                response.append(reservierung.getReservierungDetails()).append("; ");
            }
            return response.toString();
        } else {
            return "Person nicht gefunden";
        }
    }

    // Verlinkung von Reservierung zu einer Person hinzufügen
    @GetMapping(path = "/addReservierungToPerson")
    public @ResponseBody String addReservierungToPerson(@RequestParam int personId, @RequestParam String reservierungDetails) {
        Optional<Person> personOptional = personService.getPersonById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            Reservierung reservierung = new Reservierung(reservierungDetails, person, null);
            reservierungRepository.save(reservierung);
            return "Reservierung erfolgreich hinzugefügt!";
        } else {
            return "Person nicht gefunden";
        }
    }

    // HTML-Seite mit einer Liste aller Personen und deren Anzahl anzeigen
    @RequestMapping(value = "/listPersons", method = RequestMethod.GET)
    public String listPersons(ModelMap model) {
        model.put("persons", personService.getAllPersons());
        model.put("anzahl", personService.countPersons());
        return "list-persons";
    }
}

