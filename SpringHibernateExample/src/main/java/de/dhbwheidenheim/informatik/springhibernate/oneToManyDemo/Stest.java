package de.dhbwheidenheim.informatik.springhibernate.oneToManyDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stest {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	private String sname;
	
	@ManyToOne
	@JoinColumn(name="rlink")
	private Rtest rlink;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Rtest getRlink() {
		return rlink;
	}

	public void setRlink(Rtest rlink) {
		this.rlink = rlink;
	}
	
}
