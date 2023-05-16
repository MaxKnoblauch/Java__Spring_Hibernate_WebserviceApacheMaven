package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heirat {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="partner1")
	private Person partner1;

	@ManyToOne
	@JoinColumn(name="partner2")
	private Person partner2;

	
	public Heirat(Person p1, Person p2) {
		partner1 = p1;
		partner2 = p2;
		date = new Date();
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getPartner1() {
		return partner1;
	}

	public void setPartner1(Person partner1) {
		this.partner1 = partner1;
	}

	public Person getPartner2() {
		return partner2;
	}

	public void setPartner2(Person partner2) {
		this.partner2 = partner2;
	}


	
}
