package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String vorname;
    private int age;

    @OneToMany(mappedBy = "person")
    private List<Reservierung> reservierungen;

    public Person() {}

    public Person(String name, String vorname, int age) {
        this.name = name;
        this.vorname = vorname;
        this.age = age;
    }

    // Getter und Setter
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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Reservierung> getReservierungen() {
        return reservierungen;
    }

    public void setReservierungen(List<Reservierung> reservierungen) {
        this.reservierungen = reservierungen;
    }
}

}
