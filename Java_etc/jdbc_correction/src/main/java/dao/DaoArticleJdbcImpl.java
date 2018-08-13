package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.util.Context;
import model.Adherent;
import model.Article;
import model.BluRay;
import model.Dvd;

public class DaoArticleJdbcImpl implements DaoArticle {

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article findByKey(Integer key) {
		Article article = null;
		SQLRequest request = new SQLRequest();
		ResultSet rs = request.selectArticleByKey(Context.getInstance(), key);
		try {
			if (rs.next()) {
				if (rs.getString("type").equals("D")) {
					article = new Dvd(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"), rs.getBoolean("ar.bonus"));
				} else {
					article = new BluRay(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"), rs.getBoolean("ar.troisd"));
				}
				if (rs.getInt("ar.emprunteur") != 0) {
					article.setEmprunteur(
							new Adherent(rs.getInt("ar.emprunteur"), rs.getString("ad.prenom"), rs.getString("ad.nom")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public void insert(Article obj) {
		SQLRequest requetes = new SQLRequest();
		if (obj instanceof Dvd) {
			requetes.insertDvd(Context.getInstance(), obj.getNbDisques(), ((Dvd) obj).getBonus());
		} else if (obj instanceof BluRay) {
			requetes.insertBluRay(Context.getInstance(), obj.getNbDisques(), ((BluRay) obj).getTroisD());
		}
	}

	@Override
	public Article update(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Article obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByKey(Integer key) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BluRay> findAllBluRay() {
		// TODO Auto-generated method stub
		return null;
	}

}
