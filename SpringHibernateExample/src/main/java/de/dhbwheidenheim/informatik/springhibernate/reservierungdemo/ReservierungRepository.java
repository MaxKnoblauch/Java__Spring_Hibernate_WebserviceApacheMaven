package de.dhbwheidenheim.informatik.springhibernate.reservierungdemo;

import org.springframework.data.repository.CrudRepository;

// Automatisches CRUD-Repository für Reservierung
public interface ReservierungRepository extends CrudRepository<Reservierung, Integer> {

}
