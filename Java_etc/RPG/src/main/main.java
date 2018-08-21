package main;

import equipements.Jambes;
import equipements.MainDroite;
import equipements.MainGauche;
import equipements.Materiaux;
import equipements.Tete;
import equipements.Torse;
import persos.Monster;
import persos.Player;

public class main {

	public static void main(String[] args) {
		
		
		
		Player p = Player.playerGenerator();
		
		Monster m = Monster.CHTULHU;
		
		MainDroite epeeRouillee = MainDroite.EPEE_ROUILLEE;
		MainGauche bouclier = MainGauche.BOUCLIER_EN_BOIS;
		Torse armure = Torse.ARMURE_DE_CUIR;
		Jambes jambieres = Jambes.PANTALON_EN_CUIR;
		Tete casque = Tete.CASQUE_ROUILLE;
		
		p.getInventaire().ajouter(Materiaux.TISSU2);
		p.getInventaire().afficher();
		p.getInventaire().ajouter(Materiaux.CUIR2);
		p.getInventaire().afficher();
		
		p.getInventaire().ajouter(epeeRouillee);
		
		p.getInventaire().afficher();
	}


	

	
}
