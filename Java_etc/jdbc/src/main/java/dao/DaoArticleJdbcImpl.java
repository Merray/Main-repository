package dao;

import java.sql.ResultSet;
import java.util.List;

import jdbc.model.Adherent;
import jdbc.model.Article;
import jdbc.model.BluRay;
import jdbc.model.Dvd;
import jdbc.util.Context;

public class DaoArticleJdbcImpl implements DaoArticle{

	public DaoArticleJdbcImpl() {
	}

	@Override
	public List<Article> findAll() {
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
				} else if (rs.getString("type").equals("B")) {
					article = new Dvd(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"), rs.getBoolean("ar.troisd"));
				}
				if (rs.getInt("emprunteur") != 0 ) {
					new Adherent(rs.getInt("ar.emprunteur"), rs.getString("ad.nom"), rs.getString("ad.prenom"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public void insert(Article obj) {
		SQLRequest request = new SQLRequest();
		
		if(obj instanceof Dvd) {
			
			request.insertDvd(Context.getInstance(), obj.getNbDisques(), ((Dvd) obj).getBonus());
			
		} else if (obj instanceof BluRay) {
			request.insertBluRay(Context.getInstance(), obj.getNbDisques(), ((BluRay) obj).getTroisD());
		}
	}

	@Override
	public Article update(Article obj) {
		return null;
	}

	@Override
	public void delete(Article obj) {
		
	}

	@Override
	public void deleteByKey(Integer key) {
		
	}

}
