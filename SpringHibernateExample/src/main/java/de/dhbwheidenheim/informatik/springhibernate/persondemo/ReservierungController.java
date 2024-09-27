package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ReservierungController {

    @Autowired
    private ReservierungRepository reservierungRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/addReservierung")
    public @ResponseBody String addReservierung(@RequestParam String details, @RequestParam int personId) {
        try {
            Optional<Person> personOptional = personRepository.findById(personId);
            if (personOptional.isPresent()) {
                Person person = personOptional.get();
                Reservierung reservierung = new Reservierung(details, person);
                reservierungRepository.save(reservierung);
                return "Reservierung erfolgreich hinzugefügt!";
            } else {
                return "Person nicht gefunden!";
            }
        } catch (Exception e) {
            return "Fehler: " + e.getMessage();
        }
    }
    
  

    @GetMapping(path = "/reservierungen")
    public @ResponseBody Iterable<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }
}
