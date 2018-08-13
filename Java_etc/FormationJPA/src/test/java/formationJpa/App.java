package formationJpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import dao.DaoPersonne;
import dao.DaoPersonneFactory;
import dao.DaoSalle;
import dao.DaoSalleFactory;
import formationJpa.model.Civilite;
import formationJpa.model.Formateur;
import formationJpa.model.Personne;
import formationJpa.model.Salle;
import formationJpa.model.Stagiaire;
import formationJpa.util.Context;

public class App {
	public static void main(String[] args) {
		Formateur olivier = new Formateur();
		 olivier.setPrenom("ol");

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<Formateur>> cv = validator.validate(olivier);
		for (ConstraintViolation<Formateur> c : cv) {
			System.out.println(c.getMessage());
		}
		if (cv.isEmpty()) {
			DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
			System.out.println(daoPersonne.findAll());
			daoPersonne.insert(olivier);
			olivier.setCivilite(Civilite.M);
			olivier.setNom("gozlan");

			// Calendar calendar = Calendar.getInstance();
			// calendar.set(1975, 0, 5);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			try {
				olivier.setDtNaiss(sdf.parse("05/01/1975"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			olivier.setAnneeExperience(20);
			olivier = (Formateur) daoPersonne.update(olivier);
			System.out.println(daoPersonne.findByKey(50).getCivilite().getTitre());

			Stagiaire florent = new Stagiaire("florent", "h");
			florent.setEntreprise("sopra steria");

			Salle emeraude = new Salle();
			emeraude.setNom("emeraude");
			emeraude.setEtage(2);

			DaoSalle daoSalle = DaoSalleFactory.getInstance();

			daoSalle.insert(emeraude);
			olivier.setSalle(emeraude);
			olivier = (Formateur) daoPersonne.update(olivier);
			florent.setSalle(emeraude);
			daoPersonne.insert(florent);
			System.out.println("----------------");
			// daoSalle.findByKey(50).getPersonnes().toString();

			List<Salle> salles = daoSalle.findAllWithPersonne();
			for (Salle s : salles) {
				System.out.println(s + " " + s.getPersonnes());
			}
		}
		// a faire en dernier
		Context.destroy();

	}
}
