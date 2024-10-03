package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservierungService {

    @Transactional
    public void addReservierung(int personId, int objektId, String details, LocalDateTime startDatum, LocalDateTime endDatum) {
        // Logik zur Reservierung wie bisher
    }
}


