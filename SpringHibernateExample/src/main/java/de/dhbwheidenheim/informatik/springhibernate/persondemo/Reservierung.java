package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Objekt objekt;

    private LocalDateTime startDatum;
    private LocalDateTime endDatum;
    private String details;

    // Standard-Konstruktor
    public Reservierung() {
    }

    // Konstruktor mit Parametern
    public Reservierung(String details, LocalDateTime startDatum, LocalDateTime endDatum, Person person, Objekt objekt) {
        this.details = details;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.person = person;
        this.objekt = objekt;
    }

    // Getter und Setter
    public Long getId() {
        return id;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

