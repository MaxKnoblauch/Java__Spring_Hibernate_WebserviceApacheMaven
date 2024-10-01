package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PostMapping(path = "/reservierungen")
    public String addReservierung(@RequestParam String details,
                                   @RequestParam int personId,
                                   @RequestParam int objektId,
                                   @RequestParam String startDatum,
                                   @RequestParam String endDatum,
                                   RedirectAttributes redirectAttributes) {
        try {
            // Datumseingaben in LocalDateTime konvertieren
            LocalDateTime start = LocalDateTime.parse(startDatum);
            LocalDateTime end = LocalDateTime.parse(endDatum);

            // Prüfung, ob die Person existiert
            Optional<Person> personOptional = personRepository.findById(personId);
            if (!personOptional.isPresent()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Person nicht gefunden!");
                return "redirect:/"; // Leitet zur Startseite
            }
            Person person = personOptional.get();

            // Prüfung, ob das Objekt existiert
            Optional<Objekt> objektOptional = objektRepository.findById(objektId);
            if (!objektOptional.isPresent()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Objekt nicht gefunden!");
                return "redirect:/"; // Leitet zur Startseite
            }
            Objekt objekt = objektOptional.get();

            // Zeitkonflikt-Prüfung
            boolean konfliktBesteht = reservierungRepository.existsByObjektAndZeitraum(objekt, start, end);
            if (konfliktBesteht) {
                redirectAttributes.addFlashAttribute("errorMessage", "Zeitkonflikt: Das Objekt ist in diesem Zeitraum bereits reserviert!");
                return "redirect:/"; // Leitet zur Startseite
            }

            // Wenn kein Konflikt besteht, wird die Reservierung hinzugefügt
            Reservierung reservierung = new Reservierung(details, start, end, person, objekt);
            reservierungRepository.save(reservierung);
            redirectAttributes.addFlashAttribute("message", "Reservierung erfolgreich hinzugefügt!"); // Bestätigungsnachricht
            return "redirect:/"; // Leitet zur Startseite

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler: " + e.getMessage());
            return "redirect:/"; // Leitet zur Startseite
        }
    }


    // Rückgabe aller Reservierungen
    @GetMapping(path = "/reservierungen")
    public @ResponseBody Iterable<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }
}

