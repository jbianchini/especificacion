package org.hibernate.tutorial.em;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
    private Long id;	
	private long cuit;
	private String razonSocial;
	
	private Direccion dir;

	public Cliente(){
		
	}
	public Cliente(long cuit, String razonSocial) {
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}
	
	@Id
	@GeneratedValue
    public Long getId() {
		return id;
    }

    private void setId(Long id) {
		this.id = id;
    }

    
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@OneToOne(cascade = CascadeType.ALL)	
	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}
}
