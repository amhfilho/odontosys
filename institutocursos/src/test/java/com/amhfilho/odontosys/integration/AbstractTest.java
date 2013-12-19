package com.amhfilho.odontosys.integration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.naming.java.javaURLContextFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amhfilho.odontosys.model.Pessoa;

public class AbstractTest {
	@BeforeClass
	public static void setUpClass() throws Exception {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				javaURLContextFactory.class.getName());
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		InitialContext ic = new InitialContext();

		ic.createSubcontext("java:");
		ic.createSubcontext("java:comp");
		ic.createSubcontext("java:comp/env");
		ic.createSubcontext("java:comp/env/jdbc");

		EmbeddedDataSource ds = new EmbeddedDataSource();
		ds.setDatabaseName("odontosysDB");
		// tell Derby to create the database if it does not already exist
		ds.setCreateDatabase("create");

		ic.bind("java:comp/env/jdbc/odontosysDS", ds);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		InitialContext ic = new InitialContext();

		ic.unbind("java:comp/env/jdbc/odontosysDS");
	}

	@Test
	public void testeNovaPessoa() {

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"odontosysPU").createEntityManager();

		entityManager.getTransaction().begin();

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Antonio");

		entityManager.persist(pessoa);

		entityManager.getTransaction().commit();

		// see that the ID of the user was set by Hibernate
		System.out.println("pessoa=" + pessoa + ", user.id=" + pessoa.getId());

		Pessoa pessoaEncontrada = entityManager.find(Pessoa.class,
				pessoa.getId());

		// note that foundUser is the same instance as user and is a concrete
		// class (not a proxy)
		System.out.println("pessoaEncontrada=" + pessoaEncontrada);

		Assert.assertEquals(pessoa.getNome(), pessoaEncontrada.getNome());

		entityManager.close();
	}

}
