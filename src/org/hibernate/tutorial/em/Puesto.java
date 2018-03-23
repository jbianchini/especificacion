package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Puesto {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;


	public Puesto(){
	}
	
	public Puesto(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
		
	public Long getId(){
		return id;
	}
	
	private void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@OneToMany(mappedBy = "puesto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	
}
 