package main;

import equipements.Jambes;
import equipements.MainDroite;
import equipements.MainGauche;
import equipements.Materiaux;
import equipements.Tete;
import equipements.Torse;
import persos.Inventaire;
import persos.Monster;
import persos.Player;

public class main {

	public static void main(String[] args) {
		
		
		
		Player p = Player.playerGenerator();
		p.setInventaire(Inventaire.SAC_SANS_FOND);
		
		Monster m = Monster.GOBELIN_MAGE;
		
		MainDroite epeeRouillee = MainDroite.EPEE_ROUILLEE;
		MainGauche bouclier = MainGauche.BOUCLIER_EN_BOIS;
		Torse armure = Torse.ARMURE_DE_CUIR;
		Jambes jambieres = Jambes.PANTALON_EN_CUIR;
		Tete casque = Tete.CASQUE_ROUILLE;

		
		p.getInventaire().ajouter(Materiaux.TISSU2);
		
		p.getInventaire().afficher();
		
		p.getInventaire().ajouter(Materiaux.TISSU1);
		
		p.getInventaire().afficher();
		
		p.getInventaire().ajouter(Materiaux.CUIR2);
		
		p.getInventaire().afficher();
		
		p.getInventaire().ajouter(MainDroite.EPEE_EN_BON_ETAT);
		
		p.getInventaire().afficher();
		p.getInventaire().ajouter(MainDroite.EPEE_EN_BON_ETAT);
		
		p.getInventaire().afficher();
		
		System.out.println(p.getInventaire().getSize());
	}


	

	
}
