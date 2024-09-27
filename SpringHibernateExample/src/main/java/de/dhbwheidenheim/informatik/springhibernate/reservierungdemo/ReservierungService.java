package de.dhbwheidenheim.informatik.springhibernate.reservierungdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository reservierungRepository;

    public void addReservierung(Reservierung reservierung) {
        reservierungRepository.save(reservierung);
    }

    public Iterable<Reservierung> getAllReservierungen() {
        return reservierungRepository.findAll();
    }
}
