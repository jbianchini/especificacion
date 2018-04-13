package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class C {
	
	@Id
	@GeneratedValue
	private Long id;
	private String c1;
	private String c2;
	
	public C() {
	}
	
	public C(String c1, String c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getC1() {
		return c1;
	}
	
	public String getC2() {
		return c2;
	}
	

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<B> bees = new ArrayList<B>();
	
	public List<B> getBees(){
		return bees;
	}
	
	
}
