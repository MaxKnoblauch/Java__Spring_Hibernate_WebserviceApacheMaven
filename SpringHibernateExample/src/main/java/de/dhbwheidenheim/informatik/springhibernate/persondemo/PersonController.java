package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(path = "/persondemo") // Der URL-Pfad für Person-Demo-Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ReservierungRepository reservierungRepository;
    
    

    // Neue Person hinzufügen über ein Formular
   
        
    @PostMapping(path = "/persondemo/addPerson")
    public String addPerson(@RequestParam String name, 
                            @RequestParam String vorname, 
                            @RequestParam int age, 
                            RedirectAttributes redirectAttributes) {
        try {
            Person p = new Person(name, vorname, age);
            personService.addPerson(p);
            redirectAttributes.addFlashAttribute("message", "Person erfolgreich hinzugefügt!");
            return "redirect:/"; // Zurück zur Startseite
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler: " + e.getMessage());
            return "redirect:/error"; // Weiterleitung zur Fehlerseite
        }
    }

    


    
    

    // Alle Personen anzeigen
    @GetMapping(path = "/allPersons")
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }
    
    
    
    
    
    /*

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
    @GetMapping(value = "/listPersons")
    public String listPersons(ModelMap model) {
        model.put("persons", personService.getAllPersons());
        model.put("anzahl", personService.countPersons());
        return "list-persons"; // Rückgabe zur JSP-Seite
    }
    
    */
}
