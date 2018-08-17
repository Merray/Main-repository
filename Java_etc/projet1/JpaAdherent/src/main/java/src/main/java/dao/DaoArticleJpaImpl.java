package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import src.main.java.model.Adherent;
import src.main.java.model.Article;
import src.main.java.util.Context;

class DaoArticleJpaImpl implements DaoArticle{

	public DaoArticleJpaImpl() {
		
	}

	@Override
	public List<Article> findAll() {
		EntityManager em = Context.getInstance().createEntityManager(); 
		List<Article> liste= null;
		
		Query query = em.createQuery("select a from Adherent a");
		liste =query.getResultList();
		
		em.close();
		return liste;
	}

	@Override
	public Article findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Article personne = null;
		
		personne = em.find(Article.class, key);
		
		em.close();
		return personne;
	}

	@Override
	public void insert(Article obj) {
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
	public Article update(Article obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Article personne=null;
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
	public void delete(Article obj) {
		
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
			em.remove(em.find(Article.class, key));
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
