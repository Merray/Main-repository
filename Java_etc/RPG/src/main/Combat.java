package main;

import persos.Monster;
import persos.Player;

public class Combat {

	private Player p;
	private Monster m;

	public Combat(Player p, Monster m) {
		this.p = p;
		this.m = m;
	}
	
	public void go() {
		
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

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Monster getM() {
		return m;
	}

	public void setM(Monster m) {
		this.m = m;
	}

}
