package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formationJpa.model.Formateur;
import formationJpa.model.Personne;
import formationJpa.util.Context;

class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().createEntityManager();
		Query query = em.createQuery("from Personne p");
		List<Personne> personnes = query.getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Personne personne = em.find(Personne.class, key);
		em.close();
		return personne;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Personne personne = null;
		try {
			tx.begin();
			personne = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return personne;
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Personne.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public List<Formateur> findAllFormateur() {
		List<Formateur> formateurs = new ArrayList<>();
		EntityManager em = Context.getInstance().createEntityManager();
		Query query = em.createQuery("from Formateur f");
		formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

}
