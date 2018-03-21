package org.hibernate.tutorial.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class EntityManagerTest {
	private static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void setUp() throws Exception {
			entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}

	@AfterClass
	public static void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testHibernate() {
		// Creamos un cliente con su dirección
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Cliente c = new Cliente(2003581, "Cliente1");
		c.setDir(new Direccion("Domicilio1"));
	
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		entityManager.close();

		//y los recuperamos.
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        List<Cliente> result = entityManager.createQuery( "from Cliente", Cliente.class ).getResultList();
		for ( Cliente cliente : result ) {
			System.out.println( cliente.getRazonSocial() + " " + cliente.getDir().getDomicilio());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	
}
