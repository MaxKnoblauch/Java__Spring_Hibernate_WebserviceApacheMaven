package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository reservierungRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjektRepository objektRepository;

    // Liste aller Reservierungen
    public List<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }

    // Neue Reservierung erstellen
    public void addReservierung(int personId, int objektId, String details) {
        Optional<Person> person = personRepository.findById(personId);
        Optional<Objekt> objekt = objektRepository.findById(objektId);

        if (person.isPresent() && objekt.isPresent()) {
            Reservierung reservierung = new Reservierung(details, person.get(), objekt.get());
            reservierungRepository.save(reservierung);
        } else {
            throw new RuntimeException("Person oder Objekt nicht gefunden.");
        }
    }
}
