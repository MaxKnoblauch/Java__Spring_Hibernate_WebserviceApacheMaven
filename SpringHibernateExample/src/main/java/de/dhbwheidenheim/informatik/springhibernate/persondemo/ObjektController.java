package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/objekte")
public class ObjektController {

    @Autowired
    private ObjektService objektService;

    @GetMapping
    public List<Objekt> getAllObjekte() {
        return objektService.getAllObjekte();
    }

    @PostMapping
    public String addObjekt(@RequestParam String name, RedirectAttributes redirectAttributes) {
        try {
            Objekt objekt = new Objekt(name); // Sicherstellen, dass der Konstruktor in der Objekt-Klasse existiert
            objektService.addObjekt(objekt);
            redirectAttributes.addFlashAttribute("message", "Objekt erfolgreich hinzugefügt!");

            // Rückgabe mit Link zur Startseite
            return "<p>Objekt erfolgreich hinzugefügt! <a href='/'>Zurück zur Startseite</a></p>";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler: " + e.getMessage());

            // Rückgabe mit Link zur Startseite
            return "<p>Objekt konnte nicht hinzugefügt werden! <a href='/'>Zurück zur Startseite</a></p>";
        }
    }


}

