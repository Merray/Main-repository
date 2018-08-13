package videoClubJpa.test;

import videoClubJpa.dao.DaoFilm;
import videoClubJpa.dao.DaoFilmFactory;
import videoClubJpa.dao.DaoFilmRealisateur;
import videoClubJpa.dao.DaoFilmRealisateurFactory;
import videoClubJpa.dao.DaoRealisateur;
import videoClubJpa.dao.DaoRealisateurFactory;
import videoClubJpa.model.Film;
import videoClubJpa.model.FilmRealisateur;
import videoClubJpa.model.FilmRealisateurPK;
import videoClubJpa.model.Realisateur;
import videoClubJpa.util.Singleton;

public class Test {

	public static void main(String[] args) {
		Film film = new Film();
		film.setTitre("starwars");

		DaoFilm daoFilm = DaoFilmFactory.getInstance();
		daoFilm.create(film);

		Realisateur realisateur = new Realisateur();
		realisateur.setNom("lucas");
		realisateur.setPrenom("georges");

		DaoRealisateur daoRealisateur = DaoRealisateurFactory.getInstance();
		daoRealisateur.create(realisateur);

		FilmRealisateurPK key = new FilmRealisateurPK(film, realisateur);
		FilmRealisateur starwarLucas = new FilmRealisateur(key);
		DaoFilmRealisateur daoFilmRealisateur = DaoFilmRealisateurFactory.getInstance();
		daoFilmRealisateur.create(starwarLucas);

		Singleton.destroy();
	}

}
