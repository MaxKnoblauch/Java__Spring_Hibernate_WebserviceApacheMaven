package de.dhbwheidenheim.informatik.springhibernate.reservierungdemo;

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

    private String reservierungDetails;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Reservierung() {}

    public Reservierung(String reservierungDetails, Person person) {
        this.reservierungDetails = reservierungDetails;
        this.person = person;
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
}
