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
            return "Objekt erfolgreich hinzugefügt! "; // Leitet zurück zur Startseite
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler: " + e.getMessage());
            return "Objekt konnte nicht hinzugefügt werden!"; // Leitet zurück zur Startseite
        }
    }

}

