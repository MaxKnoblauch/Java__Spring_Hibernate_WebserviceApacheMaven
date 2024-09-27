package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addObjekt(@RequestBody Objekt objekt) {
        objektService.addObjekt(objekt);
    }
}

