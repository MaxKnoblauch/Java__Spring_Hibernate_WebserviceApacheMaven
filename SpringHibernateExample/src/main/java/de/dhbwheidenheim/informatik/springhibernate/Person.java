package de.dhbwheidenheim.informatik.springhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Person {
	// Dies ist die Model-Klasse... Die JSP-Dateien sind der View, und der
	// PersonController vervollkommnet das MVC Dreiergestirn

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age; // Das darf nicht "alter" hei�en - Sonst Hibernate-SQL-Fehler - das ist sehr
						// subtil!!!

	public int namenslaenge() {
		return name.length();
	}

	public boolean volljaehrig() { // Das darf nicht "istVolljaehrig" hei�en - Sonst
									// Hibernate-Session-Factory-Fehler!!!

		return age >= 18;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int alter) {
		this.age = alter;
	}

	public String toString() {
		return (name + "(" + namenslaenge() + ") - Alter:" + age);
	}

	public Person(String name, int alter) {
		this.name = name;
		this.age = alter;
	}

	public Person(String name, double alter) {
		this.name = name;
		this.age = (int) alter;
	}

	public Person(String name) {
		this.name = name;
		this.age = 0;
	}

	public Person() {
	}

}
