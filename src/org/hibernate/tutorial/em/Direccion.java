package org.hibernate.tutorial.em;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Direccion {
	
    private Long id;	
	private String domicilio;
	
	public Direccion() {
		
	}
	
	public Direccion(String domicilio) {
		
		this.domicilio = domicilio;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	@Id
	@GeneratedValue
    public Long getId() {
		return id;
    }

    private void setId(Long id) {
		this.id = id;
    }


}
