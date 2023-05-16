package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	// Dies ist die Model-Klasse... Die JSP-Dateien sind der View, und der
	// PersonController vervollkommnet das MVC Dreiergestirn

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String vorname;
	private int age; // Das darf nicht "alter" hei�en - Sonst Hibernate-SQL-Fehler 
	// - das ist sehr subtil!!!

	/* Das Folgende funktioniert zwar, hat aber den Nachteil, dass bei JSON-Ausgaben der Personen-Objekte eine Endlosschleife entsteht!
	@ManyToOne
	@JoinColumn(name="verheiratet_mit")
	private Person verheiratetMit;
	
	
	public void verheirateMit(Person partner) {
		this.verheiratetMit = partner;
		partner.verheiratetMit = this;
	}

	public Person getVerheiratetMit() {
		return verheiratetMit;
	}
	
    */
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	
	public int namenslaenge() {
		return name.length();
	}

	public boolean volljaehrig() { // Das darf nicht "istVolljaehrig" hei�en - Sonst
									// Hibernate-Session-Factory-Fehler!!!

		return age >= 18;
	}

	
    public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Person(String name, String vorname, int alter) {
		this.name = name;
		this.vorname = vorname;
		this.age = alter;
	}

	public Person(String name, String vorname, double alter) {
		this.name = name;
		this.vorname = vorname;
		this.age = (int) alter;
	}

	public Person(String name) {
		this.name = name;
		this.age = 0;
	}

	public Person() {
	}

}
