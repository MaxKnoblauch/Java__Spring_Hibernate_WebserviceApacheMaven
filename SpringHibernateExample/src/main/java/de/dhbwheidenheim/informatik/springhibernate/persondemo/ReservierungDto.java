package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.time.LocalDateTime;

public class ReservierungDto {

    private String details;
    private LocalDateTime startDatum;
    private LocalDateTime endDatum;
    private Person person;
    private int objektId;

    // Konstruktor
    public ReservierungDto(String details, LocalDateTime startDatum, LocalDateTime endDatum, Person person, int objektId) {
        this.details = details;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.person = person;
        this.objektId = objektId;
    }

    // Getter und Setter für details
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Getter und Setter für startDatum
    public LocalDateTime getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDateTime startDatum) {
        this.startDatum = startDatum;
    }

    // Getter und Setter für endDatum
    public LocalDateTime getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDateTime endDatum) {
        this.endDatum = endDatum;
    }

    // Getter und Setter für person
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Getter und Setter für objektId
    public int getObjektId() {
        return objektId;
    }

    public void setObjektId(int objektId) {
        this.objektId = objektId;
    }
}
