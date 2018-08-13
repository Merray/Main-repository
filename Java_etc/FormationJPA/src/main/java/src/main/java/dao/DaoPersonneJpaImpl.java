package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Formateur;
import src.main.java.model.Personne;
import src.main.java.util.Context;

class DaoPersonneJpaImpl implements DaoPersonne{

	public DaoPersonneJpaImpl() {
		
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Personne> liste= null;
		
		Query query = em.createQuery("select p from Personne p");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Formateur> liste= null;
		
		Query query = em.createQuery("select f from Formateur f");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}
	
	@Override
	public Personne findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Personne personne = null;
		
		personne = em.find(Personne.class, key);
		
		em.close();
		return personne;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		
		
		EntityTransaction tx =em.getTransaction();
		
		
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if (em != null && em.isOpen()) {
			em.close();
			}
		}
		
		
		
		
		
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Personne personne=null;
		try {
			tx.begin();
			personne = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if (em != null && em.isOpen()) {
			em.close();
			}
		}
		
		
		return personne;
	}

	@Override
	public void delete(Personne obj) {
		
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx =em.getTransaction();
		
		
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if (em != null && em.isOpen()) {
			em.close();
			}
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx =em.getTransaction();
		
		
		try {
			tx.begin();
			em.remove(em.find(Personne.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if (em != null && em.isOpen()) {
			em.close();
			}
		}
		
	}

}
