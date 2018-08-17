package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Adherent;
import src.main.java.model.Film;
import src.main.java.util.Context;

class DaoFilmJpaImpl implements DaoFilm{

	public DaoFilmJpaImpl() {
		
	}

	@Override
	public List<Film> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Film> liste= null;
		
		Query query = em.createQuery("select a from Adherent a");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public Film findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Film personne = null;
		
		personne = em.find(Film.class, key);
		
		em.close();
		return personne;
	}

	@Override
	public void insert(Film obj) {
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
	public Film update(Film obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Film personne=null;
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
	public void delete(Film obj) {
		
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
			em.remove(em.find(Film.class, key));
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
