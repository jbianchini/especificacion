package org.hibernate.tutorial.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

	@Ignore
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
	
	@Ignore
	public void testCreandoEmpleado() {
		Empleado e = new Empleado("Juan","Posadas");
		e.setPuesto(new Puesto("Estudia", "Info"));
		PersonaDAO asist = new PersonaDAO();
		asist.saveEmpleado(e);
		Empleado a = new Empleado("Pepe", "Pompin");
		a.setPuesto(new Puesto("Nono", "Solo klav kalash"));
		asist.saveEmpleado(a);
	}
	
	@Test
	public void testCreandoLetras() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		//vaciamos las tablas para no tener repetidos
		entityManager.createQuery("DELETE from A").executeUpdate();
		entityManager.createQuery("DELETE from B").executeUpdate();
		entityManager.createQuery("DELETE from C").executeUpdate();
		entityManager.getTransaction().commit();
		
		//-------------------- Creamos las A------------------------
		A a1 = new A("a1_1");
		A a2 = new A("a2_1");
		A a3 = new A("a3_1");
		A a4 = new A("a4_1");
	
		entityManager.getTransaction().begin();
		entityManager.persist(a1);
		entityManager.persist(a2);
		entityManager.persist(a3);
		entityManager.persist(a4);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//y los recuperamos.
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        List<A> result = entityManager.createQuery( "from A", A.class ).getResultList();
		for ( A a : result ) {
			System.out.println( a.getA1());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
        
        //
        //------------------creamos las b-------------------- 
        entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        for(int i=0; i<50;i++) {
    		B b = new B("b1_" + i, "b2_" + i);
    		if (i==0){
    			//TODO: hacer que la primera b tenga todas las A
    		}
    		entityManager.persist(b);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        
        //y los recuperamos.
  		entityManager = entityManagerFactory.createEntityManager();
  		entityManager.getTransaction().begin();
  		List<B> result2 = entityManager.createQuery( "from B", B.class ).getResultList();
  		for ( B b : result2 ) {
  			System.out.println( b.getB1() + b.getB2());
  		}
  		entityManager.getTransaction().commit();
  		entityManager.close();
		
  		//-------------------------creamos las C---------------------
  		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        for(int i=0; i<100;i++) {
    		C c = new C("c1_" + i, "c2_" + i);
    		entityManager.persist(c);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        
        //y los recuperamos.
  		entityManager = entityManagerFactory.createEntityManager();
  		entityManager.getTransaction().begin();
  		List<C> result3 = entityManager.createQuery( "from C", C.class ).getResultList();
  		for ( C c : result3 ) {
  			System.out.println( c.getC1() + c.getC2());
  		}
  		entityManager.getTransaction().commit();
  		entityManager.close();
	}
	
	
}
