package persos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import equipements.Jambes;
import equipements.MainDroite;
import equipements.MainGauche;
import equipements.Tete;
import equipements.Torse;

public class Player implements Attacker<Monster> {

	private Integer lvl;
	private Integer xpLeft;
	private String name;
	private Integer pvMax, pv, sTr, mag, pDef, mDef, con;
	private MainDroite mainDroite;
	private MainGauche mainGauche;
	private Torse torse;
	private Jambes jambes;
	private Tete tete;
	private Inventaire inventaire;

	public static Map<Integer, Integer> xpMap = new HashMap<Integer, Integer>();

	static {

		for (int i = 1; i <= 100; i++) {

			xpMap.put(i, 2 * i + 3);
		}

	}

	public Player() {
	}

	public Player(Integer lvl, Integer xpLeft, String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef,
			Integer mDef, Integer con) {
		this.lvl = lvl;
		this.xpLeft = xpLeft;
		this.name = name;
		this.pvMax = pvMax;
		pv = pvMax;
		this.sTr = sTr;
		this.mag = mag;
		this.pDef = pDef;
		this.mDef = mDef;
		this.con = con;
		this.inventaire = Inventaire.RIEN;
	}

	public Player(String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef, Integer mDef, Integer con,
			MainDroite mainDroite, MainGauche mainGauche, Torse torse, Jambes jambes, Tete tete) {
		this.name = name;
		this.pvMax = pvMax;
		pv = pvMax;
		this.sTr = sTr;
		this.mag = mag;
		this.pDef = pDef;
		this.mDef = mDef;
		this.con = con;
		this.mainDroite = mainDroite;
		this.mainGauche = mainGauche;
		this.torse = torse;
		this.jambes = jambes;
		this.tete = tete;
		this.inventaire = Inventaire.RIEN;
	}

	// Affiche les stats
	@Override
	public String toString() {
		return "\n\n------------- " + name + " -------------\n\n Lvl: " + lvl + "\t\t xpLeft: " + xpLeft + "\n pvMax: " + pvMax
				+ "\t\t pv: " + pv + "/" + pvMax + "\n sTr: " + sTr + "\t\t\t mag: " + mag + "\n pDef: " + pDef
				+ "\t\t mDef: " + mDef + "\n con: " + con;
	}

	public void lvlUp(Monster m) {
		while (m.getXpGiven() > 0) {
			this.xpLeft -= 1;
			m.setXpGiven(m.getXpGiven() - 1);
			if (xpLeft == 0) {
				lvl += 1;
				xpLeft = xpMap.get(lvl);
				System.out.println("\n" + name + " vient de passer niveau " + lvl + " !");
				this.boostStats();
			}
		}
	}

	public void boostStats() {
		// Gérer le up de stats par classe
	}
	
	public static Player playerGenerator(Integer lvl) {

		String name;
		Integer pvMax, sTr, mag, pDef, mDef, con;

		Scanner sc = new Scanner(System.in);
		System.out.println("Nom du personnage ?");
		name = sc.nextLine();

		pvMax = 10 + randomNumber(-3, 3);
		sTr = 5 + randomNumber(-1, 1);
		mag = 3 + randomNumber(-1, 1);
		pDef = 2 + randomNumber(-1, 1);
		mDef = 2 + randomNumber(-1, 1);
		con = 3 + randomNumber(-1, 1);

		Player player = new Player(lvl, xpMap.get(lvl), name, pvMax, sTr, mag, pDef, mDef, con);

		sc.close();
		return player;

	}

	public static Integer randomNumber(Integer min, Integer max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;

	}

	@Override
	public boolean do_p_dmg(Monster ennemy) {

		Integer randDmg = randomNumber(1, 4);
		Integer dmg = this.sTr - ennemy.getpDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("\n" + ennemy.getName() + " a évité l'attaque de " + this.name);
		} else {
			System.out.println("\n"+ this.name+ " a infligé " + dmg + " dégats à "+ ennemy.getName()+ " !");
		}

		return ennemy.getPv() <= 0;

	}

	@Override
	public boolean do_m_dmg(Monster ennemy) {

		Integer randDmg = randomNumber(1, 4);
		Integer dmg = this.mag - ennemy.getmDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("\n" + ennemy.getName() + " a évité le sort de " + this.name);
		} else {
			System.out.println("\n"+ this.name+ " a infligé " + dmg + " dégats à "+ ennemy.getName()+ " !");
		}

		return ennemy.getPv() <= 0;

	}

	public MainDroite getMainDroite() {
		return mainDroite;
	}

	public void setMainDroite(MainDroite mainDroite) {
		this.mainDroite = mainDroite;
	}

	public MainGauche getMainGauche() {
		return mainGauche;
	}

	public void setMainGauche(MainGauche mainGauche) {
		this.mainGauche = mainGauche;
	}

	public Torse getTorse() {
		return torse;
	}

	public void setTorse(Torse torse) {
		this.torse = torse;
	}

	public Jambes getJambes() {
		return jambes;
	}

	public void setJambes(Jambes jambes) {
		this.jambes = jambes;
	}

	public Tete getTete() {
		return tete;
	}

	public void setTete(Tete tete) {
		this.tete = tete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPvMax() {
		return pvMax;
	}

	public void setPvMax(Integer pvMax) {
		this.pvMax = pvMax;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getsTr() {
		return sTr;
	}

	public void setsTr(Integer sTr) {
		this.sTr = sTr;
	}

	public Integer getMag() {
		return mag;
	}

	public void setMag(Integer mag) {
		this.mag = mag;
	}

	public Integer getpDef() {
		return pDef;
	}

	public void setpDef(Integer pDef) {
		this.pDef = pDef;
	}

	public Integer getmDef() {
		return mDef;
	}

	public void setmDef(Integer mDef) {
		this.mDef = mDef;
	}

	public Integer getCon() {
		return con;
	}

	public void setCon(Integer con) {
		this.con = con;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public Integer getXpLeft() {
		return xpLeft;
	}

	public void setXpLeft(Integer xpLeft) {
		this.xpLeft = xpLeft;
	}

	public Map<Integer, Integer> getXpMap() {
		return xpMap;
	}

	public void setXpMap(Map<Integer, Integer> xpMap) {
		this.xpMap = xpMap;
	}

}
