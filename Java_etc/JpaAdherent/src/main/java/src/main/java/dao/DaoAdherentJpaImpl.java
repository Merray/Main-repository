package src.main.java.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Adherent;
import src.main.java.util.Context;

class DaoAdherentJpaImpl implements DaoAdherent{

	public DaoAdherentJpaImpl() {
		
	}

	@Override
	public List<Adherent> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Adherent> liste= null;
		
		Query query = em.createQuery("select a from Adherent a");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public Adherent findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Adherent personne = null;
		
		personne = em.find(Adherent.class, key);
		
		em.close();
		return personne;
	}
	
	public List<Adherent> findByCity(String city) {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Adherent> liste = null;
		
		Query query = em.createNamedQuery("Adherent.findByCity");
		
		query.setParameter("ville", city);
		
		liste = query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public void insert(Adherent obj) {
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
	public Adherent update(Adherent obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Adherent personne=null;
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
	public void delete(Adherent obj) {
		
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
			em.remove(em.find(Adherent.class, key));
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
