package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Verweist auf die index.jsp im Verzeichnis src/main/webapp
        return "jsp/index"; // Hier wird die JSP-Datei index.jsp aufgerufen
    }

    @GetMapping("/personen-form")
    public String personForm() {
        return "add-person"; // Verwende die JSP-Datei add-person.jsp
    }

    @GetMapping("/objekte-form")
    public String objektForm() {
        return "addObjekt"; // Verwende die JSP-Datei addObjekt.jsp
    }

    @GetMapping("/reservierungen-form")
    public String reservierungForm() {
        return "addReservierung"; // Verwende die JSP-Datei addReservierung.jsp
    }
    
    @GetMapping("/test")
    public String testPage() {
        return "test";  // Dies würde auf WEB-INF/jsp/test.jsp zeigen
    }

}
