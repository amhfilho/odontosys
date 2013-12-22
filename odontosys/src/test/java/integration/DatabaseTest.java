package integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amhfilho.odontosys.model.Professor;

public class DatabaseTest {
	
	static EntityManagerFactory emf;
	EntityManager em ;
	
	@BeforeClass
	public static void setupClass(){
		emf = Persistence.createEntityManagerFactory("odontosysPU");
	}
	
	@AfterClass
	public static void tearDownClass() {
		emf.close();
		emf=null;
	}
	
	@Test
	public void testarConexaoDB() {
		em = emf.createEntityManager();
	}
	
	@Test
	public void testarNovoProfessor() {
		Professor prof = new Professor();
		prof.setNome("Prof Teste");
		prof.setEmail("profteste@amhfilho.com");
		prof.setCro("12345");
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(prof);
		em.getTransaction().commit();
		Assert.assertNotNull(prof.getId());
		
		Professor profEncontrado = em.find(Professor.class, prof.getId());
		Assert.assertNotNull(profEncontrado);
		
		Assert.assertEquals(profEncontrado, prof);
		
		em.remove(prof);
	}
	
	

}
