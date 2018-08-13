package videoClubJpa.dao;

public class DaoFilmFactory {
	private static DaoFilm daoFilm = null;

	private DaoFilmFactory() {

	}

	public static DaoFilm getInstance() {
		if (daoFilm == null) {
			daoFilm = new DaoFilmJpaImpl();
		}
		return daoFilm;
	}
}
