package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.time.LocalDateTime;

public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {
	
	 List<Reservierung> findByObjekt(Objekt objekt);

    // Prüfen, ob eine Reservierung für das gleiche Objekt im gleichen Zeitraum existiert
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
           "FROM Reservierung r " +
           "WHERE r.objekt = :objekt " +
           "AND ((r.startDatum < :endDatum AND r.endDatum > :startDatum))")
    boolean existsByObjektAndZeitraum(@Param("objekt") Objekt objekt,
                                      @Param("startDatum") LocalDateTime startDatum,
                                      @Param("endDatum") LocalDateTime endDatum);
}



