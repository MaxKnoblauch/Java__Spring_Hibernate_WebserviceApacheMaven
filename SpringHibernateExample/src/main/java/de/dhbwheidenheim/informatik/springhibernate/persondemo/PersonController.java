package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/personen") // Der URL-Pfad für Person-Demo-Controller
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @PostMapping
    public String addPerson(
        @RequestParam String name, 
        @RequestParam String vorname, 
        @RequestParam int age,
        RedirectAttributes redirectAttributes
    ) {
        try {
            Person p = new Person(name, vorname, age);
            personService.addPerson(p);
            redirectAttributes.addFlashAttribute("message", "Person erfolgreich hinzugefügt!");

            // Rückgabe mit Link zur Startseite
            return "<p>Person erfolgreich hinzugefügt! <a href='/'>Zurück zur Startseite</a></p>";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Fehler: " + e.getMessage());

            // Rückgabe mit Link zur Startseite
            return "<p>Person konnte nicht hinzugefügt werden! <a href='/'>Zurück zur Startseite</a></p>";
        }
    }



    
    

    // Alle Personen anzeigen
    @GetMapping
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }
    
    
  
    
    
}
