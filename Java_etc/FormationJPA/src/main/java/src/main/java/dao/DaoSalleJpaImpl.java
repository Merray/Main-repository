package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Formateur;
import src.main.java.model.Personne;
import src.main.java.model.Salle;
import src.main.java.util.Context;

class DaoSalleJpaImpl implements DaoSalle{

	public DaoSalleJpaImpl() {
		
	}

	@Override
	public List<Salle> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Salle> liste= null;
		
		Query query = em.createQuery("select p from Personne p");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}


	
	@Override
	public Salle findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Salle salle = null;
		
		salle = em.find(Salle.class, key);
		
		
		em.close();
		return salle;
	}

	@Override
	public void insert(Salle obj) {
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
	public Salle update(Salle obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Salle personne=null;
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
	public void delete(Salle obj) {
		
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
			em.remove(em.find(Salle.class, key));
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
	public List<Salle> findAllWithPersonne() {
		EntityManager em = Context.getInstance().createEntityManager();
		Query query = em.createNamedQuery("Salle.findAllWithPersonnes");
		
		List<Salle> salles = query.getResultList();
		
		em.close();
		return salles;
	}

}
