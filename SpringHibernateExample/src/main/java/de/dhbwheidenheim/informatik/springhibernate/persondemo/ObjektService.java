package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjektService {

    @Autowired
    private ObjektRepository objektRepository;

    public List<Objekt> getAllObjekte() {
        return objektRepository.findAll();
    }

    public void addObjekt(Objekt objekt) {
        objektRepository.save(objekt);
    }
}
