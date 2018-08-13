package videoClubJpa.dao;

public class DaoRealisateurFactory {
	private static DaoRealisateur daoRealisateur = null;

	private DaoRealisateurFactory() {

	}

	public static DaoRealisateur getInstance() {
		if (daoRealisateur == null) {
			daoRealisateur = new DaoRealisateurJpaImpl();
		}
		return daoRealisateur;
	}
}
