package org.hibernate.tutorial.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersonaDAO {

	private static EntityManagerFactory entityManagerFactory;
	
	public PersonaDAO() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}
	
	public void saveEmpleado(Empleado e){
		
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		entityManager.persist(e);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	public Empleado getEmpleado(){
		return new Empleado();
	}
	
}
