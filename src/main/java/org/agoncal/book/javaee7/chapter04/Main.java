package org.agoncal.book.javaee7.chapter04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] agrs) {

		Book book = new Book("H2G2", 12.5F, "The Hitchicker's Guide to the Galaxy", "1-84023-742-2", 354, true);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
		EntityManager em = emf.createEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(book);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
