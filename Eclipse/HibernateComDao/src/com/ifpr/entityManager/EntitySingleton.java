package com.ifpr.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntitySingleton {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private EntitySingleton() {
		
	}
	
	synchronized public static EntityManager getEntityManager() {
		
		if(emf == null){
			
			emf = Persistence.createEntityManagerFactory("testePU");
		}
		
		if(em == null || !em.isOpen()){
			
			em = emf.createEntityManager();
		}
		
		return em;
		
	}
	
	synchronized public static void closeEntityManager() {
		
		if(em != null){
			emf.close();
		}
	}
	
}
