package org.hibernate.tutorial.em;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empleado {
	private Long legajo;
	private String nombre;
	private String apellido;
	private Puesto puesto;
	
	public Empleado(){
		
	}
	
	public Empleado(String nombre, String apellido, Puesto puesto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
	}

	@Id
	@GeneratedValue
	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@ManyToOne(cascade = CascadeType.ALL)	
	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	
}
