package org.hibernate.tutorial.em;

import java.util.ArrayList;

public class C {
	
	String c1
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<B> bees = new ArrayList<B>();
	
	public List<B> getBees(){
		return bees;
	}
	
	
}
