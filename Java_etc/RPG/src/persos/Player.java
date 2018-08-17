package persos;

import java.util.Random;
import java.util.Scanner;

import equipements.Equipement;
import equipements.Jambes;
import equipements.MainDroite;
import equipements.MainGauche;
import equipements.Tete;
import equipements.Torse;

public class Player extends Character {

	
	private MainDroite mainDroite;
	private MainGauche mainGauche;
	private Torse torse;
	private Jambes jambes;
	private Tete tete;
	
	public Player() {
		super();
	}

	public Player(String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef, Integer mDef, Integer con) {
		super(name, pvMax, sTr, mag, pDef, mDef, con);
	}

	public Player(String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef, Integer mDef, Integer con, MainDroite mainDroite, MainGauche mainGauche, Torse torse, Jambes jambes, Tete tete) {
		super(name, pvMax, sTr, mag, pDef, mDef, con);
		this.mainDroite = mainDroite;
		this.mainGauche = mainGauche;
		this.torse = torse;
		this.jambes = jambes;
		this.tete = tete;
	}

	// Affiche les stats
	@Override
	public String toString() {
		return "\n\n---------- " + name + " ----------\n\n pvMax : " + pvMax + "\t pv: " + pv + "/" + pvMax + "\n sTr: "
				+ sTr + "\t\t mag: " + mag + "\n pDef: " + pDef + "\t mDef: " + mDef + "\n con: " + con;
	}

	public static Player playerGenerator() {

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

		Player player = new Player(name, pvMax, sTr, mag, pDef, mDef, con);

		sc.close();
		return player;

	}

	private static Integer randomNumber(Integer min, Integer max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;

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
	
	

}
