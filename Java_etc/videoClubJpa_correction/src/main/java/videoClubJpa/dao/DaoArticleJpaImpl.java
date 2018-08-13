package videoClubJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClubJpa.model.Article;
import videoClubJpa.model.BluRay;
import videoClubJpa.model.Dvd;
import videoClubJpa.model.Article;
import videoClubJpa.util.Singleton;

class DaoArticleJpaImpl implements DaoArticle {

	@Override
	public List<Article> findAll() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("from Article a");
		List<Article> articles = query.getResultList();
		em.close();
		return articles;
	}

	public List<Dvd> findAllDvd() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		// Query query = em.createQuery("from Dvd d");
		Query query = em.createNamedQuery("Article.findAllDvd");
		List<Dvd> dvds = query.getResultList();
		em.close();
		return dvds;
	}

	public List<BluRay> findAllBluRay() {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Query query = em.createQuery("from BluRay b");
		List<BluRay> bluRays = query.getResultList();
		em.close();
		return bluRays;
	}

	@Override
	public Article findByKey(Integer key) {
		EntityManager em = Singleton.getInstance().createEntityManager();
		Article film = findByKey(key, em);
		em.close();
		return film;
	}

	private Article findByKey(Integer key, EntityManager em) {
		Article film = em.find(Article.class, key);
		return film;
	}

	@Override
	public void create(Article obj) {
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
	public Article update(Article obj) {
		Article film = null;
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
	public void delete(Article obj) {
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
		Article film = findByKey(key, em);
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
