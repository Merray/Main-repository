package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.Closer;
import jdbc.util.Context;

//execute les requetes SQL
class SQLRequest {
	private final static String FIND_ALL_ADHERENT = "select * from adherent";
	private final static String FIND_ADHERENT_BY_KEY = "select * from adherent where num_adherent=?";
	private final static String INSERT_ADHERENT = "insert into adherent(num_adherent,prenom,nom) values(nextval('seq_adherent'),?,?)";
	private final static String UPDATE_ADHERENT = "update adherent set prenom=?,nom=? where num_adherent=?";
	private final static String DELETE_ADHERENT = "delete from adherent where num_adherent=?";
	private final static String FIND_ARTICLE_BY_KEY = "select ar.num_article,ar.nb_disque,ar.bonus,ar.troisd,ar.emprunteur,ad.prenom,ad.nom from article ar left join adherent ad on  ar.emprunteur=ad.num_adherent where num_article=?";
	private final static String INSERT_DVD = "insert into article(type,num_article,nb_disque,bonus) values('D',?,?,?)";
	private final static String INSERT_BLURAY = "insert into article(type,num_article,nb_disque,troisd) values('B',?,?,?)";
	private final static String SELECT_ALL_BLURAY = "select * from article where type='B'";
	private final static String SELECT_ARTICLE_BY_EMPRUNTEUR = "select * from article where emprunteur=?";

	public ResultSet selectAllAdherent(Context ctx) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery(FIND_ALL_ADHERENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet selectAdherentByKey(Context ctx, int key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_ADHERENT_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int insertAdherent(Context ctx, String prenom, String nom) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_ADHERENT);
			ps.setString(1, prenom);
			ps.setString(2, nom);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_adherent')");
			if (rs.next()) {
				numeroGenere = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(st);
			Closer.closeStatement(ps);
		}
		return numeroGenere;
	}

	public int updateAdherent(Context ctx, int num_adherent, String prenom, String nom) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(UPDATE_ADHERENT);
			ps.setString(1, prenom);
			ps.setString(2, nom);
			ps.setInt(3, num_adherent);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}

		return retour;
	}

	public int deleteAdherent(Context ctx, int num_adherent) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_ADHERENT);
			ps.setInt(1, num_adherent);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}

	public int insertBluRay(Context ctx, Integer nbDisques, Boolean troisD) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_BLURAY);
			ps.setInt(1, nbDisques);
			ps.setBoolean(2, troisD);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_article')");
			if (rs.next()) {
				numeroGenere = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(st);
			Closer.closeStatement(ps);
		}
		return numeroGenere;
	}

	public int insertDvd(Context ctx, Integer nbDisques, Boolean bonus) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_DVD);
			ps.setInt(1, nbDisques);
			ps.setBoolean(2, bonus);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_article')");
			if (rs.next()) {
				numeroGenere = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(st);
			Closer.closeStatement(ps);
		}
		return numeroGenere;
	}

	public ResultSet selectArticleByKey(Context ctx, int key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_ARTICLE_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet selectArticleByEmprunteur(Context ctx, int emprunteur) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(SELECT_ARTICLE_BY_EMPRUNTEUR);
			ps.setInt(1, emprunteur);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
