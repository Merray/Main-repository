package annuaire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class App {

	public static void main(String[] args) throws Exception {

		Coordonnees jim = new Coordonnees("+33 7 44 37 52 86", "Chez Jimmy");
		Coordonnees newJim = new Coordonnees("06 44 37 52 86", "Toujours chez Jimmy");
		Coordonnees marine = new Coordonnees("+33 8 20 20 45 90", "Chez Marine");
		Coordonnees michel = new Coordonnees("07 72 89 10 55", "Chez Michel");

		HashMap<String, Coordonnees> maCollection = new HashMap<>();

		Annuaire monAnnuaire = new Annuaire(maCollection);

		monAnnuaire.ajout("Jimmy", jim);
		monAnnuaire.ajout("Michel", michel);
		monAnnuaire.ajout("Marine", marine);

		monAnnuaire.affichCoord("Jimmy");

		monAnnuaire.modifCoord("Jimmy", newJim);

		monAnnuaire.affichCoord("Jimmy");

		monAnnuaire.affichCoord("Michel");

		monAnnuaire.affichCoord("Marine");

		monAnnuaire.listerNoms();
		monAnnuaire.listerTel();
		monAnnuaire.listerAdr();

		monAnnuaire.affichAnnuaire();

//		FileOutputStream fos= new FileOutputStream("C:\\\\Users\\\\AJC\\\\Desktop\\\\monAnnuaire");
//		
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		oos.writeObject(monAnnuaire);
//		
//		oos.close();
//		fos.close();

		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\AJC\\\\Desktop\\\\monAnnuaire");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Annuaire annuaireLu = (Annuaire) ois.readObject();
		ois.close();
		fis.close();

		annuaireLu.affichAnnuaire();

	}

}
