package ifpr.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntitySingleton {
	private static EntityManager em = null;
	private static EntityManagerFactory emf;
	
	private EntitySingleton()
	{}
	public synchronized static EntityManager getEntityManager()
	{
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("testePU");
		}
		if(em == null || !em.isOpen())
		{
			em = emf.createEntityManager();
		}
		return em;
	}
	public synchronized static void close()
	{
		if(em != null)
		{
			emf.close();
		}
	}
}
