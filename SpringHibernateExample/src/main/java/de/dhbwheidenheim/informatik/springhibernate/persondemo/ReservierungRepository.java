package de.dhbwheidenheim.informatik.springhibernate.persondemo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservierungRepository extends JpaRepository<Reservierung, Long> {

    // Prüfen, ob eine Reservierung für ein Objekt in einem bestimmten Zeitraum existiert
    boolean existsByObjektAndStartDatumLessThanEqualAndEndDatumGreaterThanEqual(
        Objekt objekt, LocalDateTime endDatum, LocalDateTime startDatum);

    // Alle Reservierungen für ein bestimmtes Objekt abrufen
    List<Reservierung> findByObjekt(Objekt objekt);
}

