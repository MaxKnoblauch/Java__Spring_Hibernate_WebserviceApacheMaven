package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String details;

    private String reservierungDetails;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private Objekt objekt;

    public Reservierung() {}

    public Reservierung(String reservierungDetails, Person person) {
        this.reservierungDetails = reservierungDetails;
        this.person = person;
    }
    
    public Reservierung(String details, Person person, Objekt objekt) {
        this.details = details;
        this.person = person;
        this.objekt = objekt;
    }
    
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservierungDetails() {
        return reservierungDetails;
    }

    public void setReservierungDetails(String reservierungDetails) {
        this.reservierungDetails = reservierungDetails;
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
}
}

