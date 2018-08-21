package mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Adherent;
import model.Civilite;
import repositories.AdherentRepository;

public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AdherentRepository adherentRepository = ctx.getBean(AdherentRepository.class);
//		RealisateurRepository realisateurRepository = ctx.getBean(RealisateurRepository.class);
		
		
//		Adresse ad = new Adresse("8 rue des bois", 95000, "Paris");
//		Adresse ad2 = new Adresse("8 rue des bois", 95000, "Parisse");
//		Adherent mar = new Adherent(Civilite.MADAME.getCivilite(), "BOUTINEAU", "Marine");
//		mar.setAdresse(ad);
//		
//		adherentRepository.save(mar);
//		
//		
//		
//		mar.setAdresse(ad2);
//		adherentRepository.save(mar);
		
		
		Adherent a = new Adherent(Civilite.MONSIEUR, "CARRILLO", "Jimmy");
		Adherent a2 = new Adherent(Civilite.MADAME, "BOUTINEAU", "Marine");
		
		adherentRepository.save(a);
		adherentRepository.save(a2);
		
//		realisateurRepository.save(new Realisateur("Lucas", "Georges"));
		
		
		
	}

}
