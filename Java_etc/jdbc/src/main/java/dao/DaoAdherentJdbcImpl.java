package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.model.Adherent;
import jdbc.model.Article;
import jdbc.model.Dvd;
import jdbc.util.Closer;
import jdbc.util.Context;

class DaoAdherentJdbcImpl implements DaoAdherent {

	@Override
	public List<Adherent> findAll() {

		List<Adherent> adherents = new ArrayList<>();

		SQLRequest request = new SQLRequest();

		ResultSet rs = request.selectAllAdherent(Context.getInstance());
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
	public Adherent findByKey(Integer num_adherent) {

		Adherent adherent = null;

		SQLRequest request = new SQLRequest();

		ResultSet rs = request.selectAdherentByKey(Context.getInstance(), num_adherent);
		Statement st = null;

		try {
			st = rs.getStatement();
			if (rs.next()) {

				adherent = new Adherent(rs.getInt("num_adherent"), rs.getString("prenom"), rs.getString("nom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}

		return adherent;
	}
	
//	public List<Article> findArticleByAdherent(Adherent adherent){
//		
//		List<Article> articles; // Pas fini mais ça va trop vite alors voila
//		Article article = null;
//		SQLRequest request = new SQLRequest();
//		ResultSet rs = request.selectArticleByKey(Context.getInstance(), adherent);
//		try {
//			if (rs.next()) {
//				if (rs.getString("type").equals("D")) {
//					article = new Dvd(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"), rs.getBoolean("ar.bonus"));
//				} else if (rs.getString("type").equals("B")) {
//					article = new Dvd(rs.getInt("ar.num_article"), rs.getInt("ar.nb_disques"), rs.getBoolean("ar.troisd"));
//				}
//				if (rs.getInt("emprunteur") != 0 ) {
//					new Adherent(rs.getInt("ar.emprunteur"), rs.getString("ad.nom"), rs.getString("ad.prenom"));
//				}
//				articles.add(article);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//	}
	
	

	@Override
	public void insert(Adherent obj) {
		
		SQLRequest request = new SQLRequest();
		try {
			int numeroGenere = request.insertAdherent(Context.getInstance(), obj.getPrenom(), obj.getNom());
			obj.setNumeroAdherent(numeroGenere); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public Adherent update(Adherent obj) {
		
		SQLRequest request = new SQLRequest();
		try {
			int nbLignesModif  = request.update(Context.getInstance(), obj.getNumeroAdherent(), obj.getPrenom(), obj.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return obj;
	}

	@Override
	public void delete(Adherent obj) {
		
		SQLRequest request = new SQLRequest();
		
		try {
			int nbLignesModif = request.deleteAdherent(Context.getInstance(), obj.getNumeroAdherent());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteByKey(Integer num_adherent) {
		
		SQLRequest request = new SQLRequest();
		
		try {
			int nbLignesModif = request.deleteAdherent(Context.getInstance(), num_adherent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
