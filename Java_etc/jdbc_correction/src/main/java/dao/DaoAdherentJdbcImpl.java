package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
import jdbc.util.Context;
import model.Adherent;
import model.Article;
import model.BluRay;
import model.Dvd;

class DaoAdherentJdbcImpl implements DaoAdherent {

	@Override
	public List<Adherent> findAll() {
		List<Adherent> adherents = new ArrayList<>();
		SQLRequest requetes = new SQLRequest();
		ResultSet rs = requetes.selectAllAdherent(Context.getInstance());
		Statement st = null;
		try {
			st = rs.getStatement();
			while (rs.next()) {
				adherents.add(new Adherent(rs.getInt("num_adherent"), rs.getString("prenom"), rs.getString("nom")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return adherents;
	}

	@Override
	public Adherent findByKey(Integer key) {
		Adherent adherent = null;
		SQLRequest requetes = new SQLRequest();
		ResultSet rs = requetes.selectAdherentByKey(Context.getInstance(), key);
		Statement st = null;
		try {
			st = rs.getStatement();
			if (rs.next()) {
				adherent = new Adherent(rs.getInt("num_adherent"), rs.getString("prenom"), rs.getString("nom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return adherent;
	}

	@Override
	public void insert(Adherent obj) {
		SQLRequest requetes = new SQLRequest();
		obj.setNumeroAdherent(requetes.insertAdherent(Context.getInstance(), obj.getPrenom(), obj.getNom()));
	}

	@Override
	public Adherent update(Adherent obj) {
		SQLRequest requetes = new SQLRequest();
		requetes.updateAdherent(Context.getInstance(), obj.getNumeroAdherent(), obj.getPrenom(), obj.getNom());
		return obj;
	}

	@Override
	public void delete(Adherent obj) {
		deleteByKey(obj.getNumeroAdherent());
	}

	@Override
	public void deleteByKey(Integer key) {
		SQLRequest requetes = new SQLRequest();
		requetes.deleteAdherent(Context.getInstance(), key);
	}

	public List<Article> findArticleByAdherent(Adherent adherent) {
		List<Article> articles = new ArrayList<>();
		Article article = null;
		SQLRequest request = new SQLRequest();
		ResultSet rs = request.selectArticleByEmprunteur(Context.getInstance(), adherent.getNumeroAdherent());
		try {
			while (rs.next()) {
				if (rs.getString("type").equals("D")) {
					article = new Dvd(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"),
							rs.getBoolean("ar.bonus"));
				} else {
					article = new BluRay(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"),
							rs.getBoolean("ar.troisd"));
				}
				if (rs.getInt("ar.emprunteur") != 0) {
					article.setEmprunteur(new Adherent(rs.getInt("ar.emprunteur"), rs.getString("ad.prenom"),
							rs.getString("ad.nom")));
				}
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

}
