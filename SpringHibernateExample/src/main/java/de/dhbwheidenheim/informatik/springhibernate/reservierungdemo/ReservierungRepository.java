package de.dhbwheidenheim.informatik.springhibernate.reservierungdemo;

import org.springframework.data.repository.CrudRepository;

import de.dhbwheidenheim.informatik.springhibernate.persondemo.Reservierung;

// Automatisches CRUD-Repository für Reservierung
public interface ReservierungRepository extends CrudRepository<Reservierung, Integer> {

}
