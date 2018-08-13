package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Adherent;
import src.main.java.model.FilmRealisateur;
import src.main.java.model.FilmRealisateurPk;
import src.main.java.util.Context;

class DaoFilmRealisateurJpaImpl implements DaoFilmRealisateur{

	public DaoFilmRealisateurJpaImpl() {
		
	}

	@Override
	public List<FilmRealisateur> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<FilmRealisateur> liste= null;
		
		Query query = em.createQuery("select a from Adherent a");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public FilmRealisateur findByKey(FilmRealisateurPk key) {
		EntityManager em = Context.getInstance().createEntityManager();
		FilmRealisateur personne = null;
		
		personne = em.find(FilmRealisateur.class, key);
		
		em.close();
		return personne;
	}

	@Override
	public void insert(FilmRealisateur obj) {
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
	public FilmRealisateur update(FilmRealisateur obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		FilmRealisateur personne=null;
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
	public void delete(FilmRealisateur obj) {
		
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
	public void deleteByKey(FilmRealisateurPk key) {
		
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx =em.getTransaction();
		
		
		try {
			tx.begin();
			em.remove(em.find(FilmRealisateur.class, key));
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
