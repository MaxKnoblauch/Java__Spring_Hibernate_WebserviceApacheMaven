package de.dhbwheidenheim.informatik.springhibernate.oneToManyDemo;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
//Dieses CRUD-Repository bildet die Model-Klasse automatisch als Relation auf der Datenbank ab.


public interface StestRepository extends CrudRepository<Stest, Integer>{

}
