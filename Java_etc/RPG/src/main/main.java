package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Player p = Player.playerGenerator(2);
		
		p.setPvMax(50);
		p.setPv(50);
		p.setInventaire(Inventaire.SAC_SANS_FOND);

		Monster m = Monster.CRASH;

		MainDroite md = MainDroite.BAGUETTE_ROI_MAGE;
		MainGauche mg = MainGauche.CHAPEAU_DE_MAGICIEN_BADASS;
		Torse ar = Torse.DECOLLETE_SEXY;
		Jambes ja = Jambes.CULOTTE_ELEGANTE;

		System.out.println(p);

		p.getInventaire().ajouter(md);
		p.getInventaire().ajouter(mg);
		p.getInventaire().ajouter(ar);
		p.getInventaire().ajouter(ja);

		p.getInventaire().equiper(md, p);
		p.getInventaire().equiper(mg, p);
		p.getInventaire().equiper(ar, p);
		p.getInventaire().equiper(ja, p);

		System.out.println(p);

		while (p.getPv() > 0 && m.getPv() > 0) {

			if (p.do_m_dmg(m)) {
				System.out.println("\n" + p.getName() + " a tué " + m.getName() + " !");
				p.lvlUp(m);
				m.dropLoot(p);
				p.getInventaire().afficher();
				System.out.println(m);
				System.out.println(p);
				break;
			}
			if (m.do_p_dmg(p)) {
				System.out.println("\n" + m.getName() + " a tué " + p.getName() + " !");
				System.out.println("\nGAME OVER !");
				System.out.println(m);
				System.out.println(p);

			}
		}

	}

}
