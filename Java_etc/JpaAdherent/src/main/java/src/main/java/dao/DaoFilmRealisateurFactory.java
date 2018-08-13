package src.main.java.dao;

public class DaoFilmRealisateurFactory {

	private static DaoFilmRealisateur daoFilmRealisateur = null;
	
	private DaoFilmRealisateurFactory() {
		
	}
	
	public static DaoFilmRealisateur getInstance() {
		
		if (daoFilmRealisateur == null) {
			
			daoFilmRealisateur = new DaoFilmRealisateurJpaImpl();
		}
		return daoFilmRealisateur;
		
	}

}
