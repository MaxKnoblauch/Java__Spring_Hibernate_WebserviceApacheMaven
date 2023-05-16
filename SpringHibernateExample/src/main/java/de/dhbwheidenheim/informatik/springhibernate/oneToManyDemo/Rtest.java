package de.dhbwheidenheim.informatik.springhibernate.oneToManyDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rtest {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	
	private String rname;
	
	public int getRid() {
		return rid;
	}

	public void setrId(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}


}
