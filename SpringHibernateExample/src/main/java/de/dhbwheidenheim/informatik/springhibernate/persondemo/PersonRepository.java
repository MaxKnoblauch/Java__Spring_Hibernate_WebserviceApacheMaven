package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.data.repository.CrudRepository;

// Das CRUD-Repository für die Person-Entität
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
