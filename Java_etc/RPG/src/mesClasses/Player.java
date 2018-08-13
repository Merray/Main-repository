package mesClasses;

import java.util.Random;
import java.util.Scanner;

public class Player extends Character {

	private int pd;

	public Player(String name, int pvMax, int sTr, int mag, int pDef, int mDef, int con, int pd) {
		super(name, pvMax, sTr, mag, pDef, mDef, con);
		this.pd = pd;
	}

	public int getPd() {
		return pd;
	}

	public void setPd(int pd) {
		this.pd = pd;
	}

	// Affiche les stats
	@Override
	public String toString() {
		return "\n---------- " + name + " ----------\n\n pvMax : " + pvMax + "\t pv: " + pv + "/" + pvMax + "\n sTr: "
				+ sTr + "\t\t mag: " + mag + "\n pDef: " + pDef + "\t mDef: " + mDef + "\n con: " + con + "\t\t pd: "
				+ pd;
	}

	public static Player playerGenerator() {

		String name;
		int pvMax, sTr, mag, pDef, mDef, con, pd;

		Scanner sc = new Scanner(System.in);
		System.out.println("Nom du personnage ?");
		name = sc.nextLine();

		pvMax = 10 + randomNumber(-3, 3);
		sTr = 5 + randomNumber(-1, 1);
		mag = 3 + randomNumber(-1, 1);
		pDef = 2 + randomNumber(-1, 1);
		mDef = 2 + randomNumber(-1, 1);
		con = 3 + randomNumber(-1, 1);
		pd = randomNumber(0, 1);

		Player player = new Player(name, pvMax, sTr, mag, pDef, mDef, con, pd);

		sc.close();
		return player;

	}

	private static int randomNumber(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;

	}

}
