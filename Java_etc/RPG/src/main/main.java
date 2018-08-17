package main;

import equipements.Jambes;
import equipements.MainDroite;
import equipements.MainGauche;
import equipements.Tete;
import equipements.Torse;
import persos.Player;

public class main {

	public static void main(String[] args) {
		
		
		
		Player p = Player.playerGenerator();
		
		MainDroite epeeRouillee = MainDroite.EPEE_ROUILLEE;
		MainGauche bouclier = MainGauche.BOUCLIER_EN_BOIS;
		Torse armure = Torse.ARMURE_DE_CUIR;
		Jambes jambieres = Jambes.PANTALON_EN_CUIR;
		Tete casque = Tete.CASQUE_ROUILLE;
		
		
		System.out.println("\nPerso avant �quiper" + p);
		System.out.println("Main droite avant �quiper: "+p.getMainDroite());

		epeeRouillee.equiper(p);
		bouclier.equiper(p);
		armure.equiper(p);
		jambieres.equiper(p);
		casque.equiper(p);
		
		System.out.println("\nPerso apr�s �quiper" + p);
		System.out.println("Main droite apr�s �quiper: "+p.getMainDroite().getNom());
		System.out.println("Main gauche apr�s �quiper: "+p.getMainGauche().getNom());
		System.out.println("Torse apr�s �quiper: "+p.getTorse().getNom());
		System.out.println("Jambes apr�s �quiper: "+p.getJambes().getNom());
		System.out.println("Tete apr�s �quiper: "+p.getTete().getNom());


		
	}


	

	
}
