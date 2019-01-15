package ifpr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ifpr.entityManager.EntitySingleton;


public class GenericDao<T> implements Dao<T>{

	
	protected Class<T> classe;
	
	public GenericDao(Class<T> classe){
		this.classe = classe;
	}
	
	public void save(T obj) {
		
		EntityManager em = EntitySingleton.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
		em.close();
	}


	public T update(T obj) {
		
		EntityManager em = EntitySingleton.getEntityManager();
		
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
		em.close();
		
		return obj;
	}


	public void remove(T obj) {
		
		EntityManager em = EntitySingleton.getEntityManager();
		
		em.getTransaction().begin();
		obj = em.merge(obj);
		em.remove(obj);
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public T findById(int id) {
		
		EntityManager em = EntitySingleton.getEntityManager();
		T obj = em.find(classe, id);
		em.close();
		
		return obj;
	}

	@Override
	public T findById(long id) {
		
		EntityManager em = EntitySingleton.getEntityManager();
		
		T obj = em.find(classe, id);
		em.close();
		
		return obj;
	
	}

	@SuppressWarnings("unchecked")
	public List<T> list(int quantidade) {
	
		
		EntityManager em = EntitySingleton.getEntityManager();
		
		String sql = "from " + classe.getSimpleName();
		Query query = em.createQuery(sql);
		query.setMaxResults(quantidade);
		
		
		List<T> results = query.getResultList();
	
		
		em.close();
	
		
		return results;
	}
	

}
