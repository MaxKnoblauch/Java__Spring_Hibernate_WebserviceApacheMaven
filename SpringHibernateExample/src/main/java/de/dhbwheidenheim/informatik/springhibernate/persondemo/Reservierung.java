package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String details;
    private LocalDateTime startDatum;
    private LocalDateTime endDatum;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "objekt_id")
    private Objekt objekt;

    public Reservierung() {}

    // Der fehlende Konstruktor
    public Reservierung(String details, Person person, Objekt objekt) {
        this.details = details;
        this.person = person;
        this.objekt = objekt;
    }

    // Anderer Konstruktor mit Zeitangaben
    public Reservierung(String details, LocalDateTime startDatum, LocalDateTime endDatum, Person person, Objekt objekt) {
        this.details = details;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.person = person;
        this.objekt = objekt;
    }

    // Getter und Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDateTime startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDateTime getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDateTime endDatum) {
        this.endDatum = endDatum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Objekt getObjekt() {
        return objekt;
    }

    public void setObjekt(Objekt objekt) {
        this.objekt = objekt;
    }

	public Object getReservierungDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

