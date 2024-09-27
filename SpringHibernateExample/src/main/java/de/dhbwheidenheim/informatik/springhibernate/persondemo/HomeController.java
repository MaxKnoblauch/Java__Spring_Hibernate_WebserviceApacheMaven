package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Verweist auf die index.jsp
        return "index";
    }

    @GetMapping("/personen-form")
    public String personForm() {
        // Verweist auf eine mögliche JSP-Seite für Personenformular
        return "personForm";
    }

    @GetMapping("/objekte-form")
    public String objektForm() {
        // Verweist auf eine mögliche JSP-Seite für Objekteformular
        return "objektForm";
    }

    @GetMapping("/reservierungen-form")
    public String reservierungForm() {
        // Verweist auf eine mögliche JSP-Seite für Reservierungenformular
        return "reservierungForm";
    }
}
