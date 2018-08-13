package videoClubJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClubJpa.model.Realisateur;
import videoClubJpa.util.Singleton;

class DaoRealisateurJpaImpl implements DaoRealisateur {

	@Override
	public List<Realisateur> findAll() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("from Realisateur r");
		List<Realisateur> realisateurs = query.getResultList();
		em.close();
		return realisateurs;
	}

	@Override
	public Realisateur findByKey(Integer key) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Realisateur realisateur = findByKey(key, em);
		em.close();
		return realisateur;
	}

	private Realisateur findByKey(Integer key, EntityManager em) {
		Realisateur realisateur = em.find(Realisateur.class, key);
		return realisateur;
	}

	@Override
	public void create(Realisateur obj) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
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
	public Realisateur update(Realisateur obj) {
		Realisateur realisateur = null;
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			realisateur = em.merge(obj);
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
		return realisateur;
	}

	@Override
	public void delete(Realisateur obj) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
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
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Realisateur realisateur = findByKey(key, em);
		if (realisateur != null) {
			try {
				tx = em.getTransaction();
				tx.begin();
				em.remove(realisateur);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
		}
		em.close();
	}

}
