package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class ReservierungController {

    @Autowired
    private ReservierungRepository reservierungRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjektRepository objektRepository;

    // Hinzufügen einer Reservierung mit Zeitkonflikt-Prüfung
    @GetMapping(path = "/addReservierung")
    public @ResponseBody String addReservierung(@RequestParam String details,
                                                @RequestParam int personId,
                                                @RequestParam int objektId,
                                                @RequestParam String startDatum,
                                                @RequestParam String endDatum) {
        try {
            // Datumseingaben in LocalDateTime konvertieren
            LocalDateTime start = LocalDateTime.parse(startDatum);
            LocalDateTime end = LocalDateTime.parse(endDatum);

            // Prüfung, ob die Person existiert
            Optional<Person> personOptional = personRepository.findById(personId);
            if (!personOptional.isPresent()) {
                return "Person nicht gefunden!";
            }
            Person person = personOptional.get();

            // Prüfung, ob das Objekt existiert
            Optional<Objekt> objektOptional = objektRepository.findById(objektId);
            if (!objektOptional.isPresent()) {
                return "Objekt nicht gefunden!";
            }
            Objekt objekt = objektOptional.get();

            // Zeitkonflikt-Prüfung
            boolean konfliktBesteht = reservierungRepository.existsByObjektAndZeitraum(objekt, start, end);
            if (konfliktBesteht) {
                return "Zeitkonflikt: Das Objekt ist in diesem Zeitraum bereits reserviert!";
            }

            // Wenn kein Konflikt besteht, wird die Reservierung hinzugefügt
            Reservierung reservierung = new Reservierung(details, start, end, person, objekt);
            reservierungRepository.save(reservierung);
            return "Reservierung erfolgreich hinzugefügt!";
        } catch (Exception e) {
            return "Fehler: " + e.getMessage();
        }
    }

    // Rückgabe aller Reservierungen
    @GetMapping(path = "/reservierungen")
    public @ResponseBody Iterable<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }
}

