package videoclub;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import videoclub.model.*;
import videoclub.repositories.*;

public class App {

	public static void main(String[] args) {

		// Initialisation du contexte et des repositories pour chaque table

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		AdherentRepository adherentRepo = ctx.getBean(AdherentRepository.class);
		ArticleRepository articleRepo = ctx.getBean(ArticleRepository.class);
		FilmRepository filmRepo = ctx.getBean(FilmRepository.class);
		RealisateurRepository realisateurRepo = ctx.getBean(RealisateurRepository.class);
		FilmRealisateurRepository filmRealisateurRepo = ctx.getBean(FilmRealisateurRepository.class);

		// Création et manipulation des objets

		Adresse adr = new Adresse();
		adr.setNumero(123);
		adr.setRue("Rue de Paris");
		adr.setVille("Paris");

		Adherent adh1 = new Adherent();
		adh1.setNom("Gozlan");
		adh1.setPrenom("Olivier");
		adh1.setCivilite(Civilite.M);
		adh1.setAdresse(adr);

		Film film1 = new Film();
		film1.setTitre("E.T.");

		Realisateur real1 = new Realisateur();
		real1.setNom("Spielberg");
		real1.setPrenom("Steven");

		FilmRealisateurPK fr1pk = new FilmRealisateurPK();
		fr1pk.setFilm(film1);
		fr1pk.setRealisateur(real1);
		FilmRealisateur fr1 = new FilmRealisateur();
		fr1.setKey(fr1pk);

		Dvd dvd1 = new Dvd();
		dvd1.setFilm(film1);
		dvd1.setEmprunteur(adh1);

		// Intégration dans la base
		filmRepo.save(film1);
		realisateurRepo.save(real1);
		filmRealisateurRepo.save(fr1);
		adherentRepo.save(adh1);
		articleRepo.save(dvd1);

	}

}
