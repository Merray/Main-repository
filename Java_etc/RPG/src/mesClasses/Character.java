package mesClasses;

import java.util.Random;

public class Character {

	protected String name;
	protected int pvMax, pv, sTr, mag, pDef, mDef, con;
	
	public Character(String name, int pvMax, int sTr, int mag, int pDef, int mDef, int con) {

		this.name = name;
		this.pvMax = pvMax;
		pv = pvMax;
		this.sTr = sTr;
		this.mag = mag;
		this.pDef = pDef;
		this.mDef = mDef;
		this.con = con;
	}

	private static int randomNumber(int min, int max) {
		if (min >= max) {throw new IllegalArgumentException("Max must be greater than min");}
		
		Random r = new Random();
		return r.nextInt((max - min)+1) + min;
		
	}
	// Attaque physique
	
	public boolean do_p_dmg(Character ennemy) {
		
		int randDmg = randomNumber(1, 4);
		int dmg = this.sTr - ennemy.pDef + randDmg;
		
		ennemy.pv -= dmg;
		
		if (dmg == 0) {System.out.println("Evité!");}
		else {System.out.println(dmg + " dégats!");}
		
		return ennemy.pv <= 0;
		
	}
	
	// Attaque magique
	
	public boolean do_m_dmg(Character ennemy) {
		
		int randDmg = randomNumber(1, 4);
		int dmg = this.mag - ennemy.mDef + randDmg;
		
		ennemy.pv -= dmg;
		
		if (dmg == 0) {System.out.println("Evité!");}
		else {System.out.println(dmg + " dégats!");}
		
		return ennemy.pv <= 0;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPvMax() {
		return pvMax;
	}

	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}

	public int getsTr() {
		return sTr;
	}

	public void setsTr(int sTr) {
		this.sTr = sTr;
	}

	public int getMag() {
		return mag;
	}

	public void setMag(int mag) {
		this.mag = mag;
	}

	public int getpDef() {
		return pDef;
	}

	public void setpDef(int pDef) {
		this.pDef = pDef;
	}

	public int getmDef() {
		return mDef;
	}

	public void setmDef(int mDef) {
		this.mDef = mDef;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}
	
	// Affiche les stats 
	@Override
	public String toString() {
		return "\n---------- "+ name + " ----------\n\n pvMax : " + pvMax + "\t pv: " + pv + "/" + pvMax +"\n sTr: " + sTr + "\t\t mag: " + mag + "\n pDef: " + pDef
				+ "\t mDef: " + mDef + "\n con: " + con;
	}
	
	
	
}
