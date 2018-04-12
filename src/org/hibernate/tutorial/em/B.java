package org.hibernate.tutorial.em;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class B {
	@Id
	@GeneratedValue
	private Long id;
	private String b1;
	private String b2;
	
	public B(){
		
	}
	
	public B(String b1, String b2) {
		this.b1 = b1;
		this.b2 = b2;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getB1() {
		return b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}


	@OneToMany(mappedBy = "unB", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<A> aes = new ArrayList<A>();
	
	public List<A> getAes() {
		return aes;
	}
	
//	@ManyToMany(mappedBy = "bees")
//	private List<C> cees = new ArrayList<C>();
//	
//	public List<C> getCees(){
//		return cees;
//	}
}
