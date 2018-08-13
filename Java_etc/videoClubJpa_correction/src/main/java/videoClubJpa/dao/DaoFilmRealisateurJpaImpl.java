package videoClubJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClubJpa.model.FilmRealisateur;
import videoClubJpa.model.FilmRealisateurPK;
import videoClubJpa.util.Singleton;

class DaoFilmRealisateurJpaImpl implements DaoFilmRealisateur {

	@Override
	public List<FilmRealisateur> findAll() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("from FilmRealisateur r");
		List<FilmRealisateur> realisateurs = query.getResultList();
		em.close();
		return realisateurs;
	}

	@Override
	public FilmRealisateur findByKey(FilmRealisateurPK key) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		FilmRealisateur realisateur = findByKey(key, em);
		em.close();
		return realisateur;
	}

	private FilmRealisateur findByKey(FilmRealisateurPK key, EntityManager em) {
		FilmRealisateur realisateur = em.find(FilmRealisateur.class, key);
		return realisateur;
	}

	@Override
	public void create(FilmRealisateur obj) {
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
	public FilmRealisateur update(FilmRealisateur obj) {
		FilmRealisateur realisateur = null;
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
	public void delete(FilmRealisateur obj) {
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
	public void deleteByKey(FilmRealisateurPK key) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		FilmRealisateur realisateur = findByKey(key, em);
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
