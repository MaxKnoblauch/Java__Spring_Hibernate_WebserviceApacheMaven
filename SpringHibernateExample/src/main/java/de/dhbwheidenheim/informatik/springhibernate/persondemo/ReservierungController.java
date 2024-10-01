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

    @PostMapping(path = "/reservierungen")
    public String addReservierung(@RequestParam String details,
                                  @RequestParam int personId,
                                  @RequestParam int objektId,
                                  @RequestParam String startDatum,
                                  @RequestParam String endDatum,
                                  RedirectAttributes redirectAttributes) {
        try {
            // Konvertierung der Datumseingaben in LocalDateTime
            LocalDateTime start = LocalDateTime.parse(startDatum);
            LocalDateTime end = LocalDateTime.parse(endDatum);

            // Person suchen
            Optional<Person> personOptional = personRepository.findById(personId);
            if (!personOptional.isPresent()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Person nicht gefunden!");
                return "redirect:/";
            }
            Person person = personOptional.get();

            // Objekt suchen
            Optional<Objekt> objektOptional = objektRepository.findById(objektId);
            if (!objektOptional.isPresent()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Objekt nicht gefunden!");
                return "redirect:/";
            }
            Objekt objekt = objektOptional.get();

            // Zeitkonflikt prüfen
            boolean konfliktBesteht = reservierungRepository.existsByObjektAndStartDatumLessThanEqualAndEndDatumGreaterThanEqual(
                objekt, end, start);
            if (konfliktBesteht) {
                redirectAttributes.addFlashAttribute("errorMessage", "Zeitkonflikt: Das Objekt ist in diesem Zeitraum bereits reserviert!");
                return "redirect:/";
            }

            // Reservierung speichern, wenn kein Konflikt besteht
            Reservierung reservierung = new Reservierung(details, start, end, person, objekt);
            reservierungRepository.save(reservierung);
            redirectAttributes.addFlashAttribute("message", "Reservierung erfolgreich hinzugefügt!");
            return "redirect:/";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler: " + e.getMessage());
            return "redirect:/";
        }
    }

    // Rückgabe aller Reservierungen
    @GetMapping(path = "/reservierungen")
    public @ResponseBody Iterable<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }
}



