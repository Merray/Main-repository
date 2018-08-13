package videoClubJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import videoClubJpa.model.Film;
import videoClubJpa.util.Singleton;

class DaoFilmJpaImpl implements DaoFilm {

	@Override
	public List<Film> findAll() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("from Film f");
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	public List<Film> findAllWithArticle() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("select distinct f from Film f left join fetch f.articles ");
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public Film findByKey(Integer key) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Film film = findByKey(key, em);
		em.close();
		return film;
	}

	public Film findByKeyWithArticles(Integer key) {
		Film film = null;
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("select distinct f from Film f left join fetch f.articles where f.id=:id");
		query.setParameter("id", key);
		try {
			film = (Film) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return film;
	}

	private Film findByKey(Integer key, EntityManager em) {
		Film film = em.find(Film.class, key);
		return film;
	}

	@Override
	public void create(Film obj) {
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
	public Film update(Film obj) {
		Film film = null;
		EntityManager em = Singleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			film = em.merge(obj);
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
		return film;
	}

	@Override
	public void delete(Film obj) {
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
		Film film = findByKey(key, em);
		if (film != null) {
			try {
				tx = em.getTransaction();
				tx.begin();
				em.remove(film);
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
