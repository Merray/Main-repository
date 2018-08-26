package persos;

import equipements.*;

public enum Monster implements Attacker<Player> {

	CHTULHU("Chtulhu", 100, 30, 27, 12, 15, 100, MainDroite.EPEE_ROUILLEE, 500),
	GOBELIN("Gobelin", 10, 2, 0, 0, 0, 1, Materiaux.CUIR1, 4),
	GOBELIN_MAGE("Gobelin mage", 8, 0, 2, 0, 0, 1, Torse.GILET, 5),
	GOBELIN_CUIRASSE("Gobelin cuirassé", 12, 3, 0, 2, 0, 2, Materiaux.FER1, 6),
	CRASH("Crash", 48, 13, 3, 10, 10, 10, MainDroite.MJOLNIR, 200);

	private String name;
	private Integer pvMax, pv, sTr, mag, pDef, mDef, con;
	private Carriable loot;
	private Integer xpGiven;

	private Monster(String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef, Integer mDef, Integer con,
			Carriable loot, Integer xpGiven) {

		this.name = name;
		this.pvMax = pvMax;
		pv = pvMax;
		this.sTr = sTr;
		this.mag = mag;
		this.pDef = pDef;
		this.mDef = mDef;
		this.con = con;
		this.loot = loot;
		this.xpGiven = xpGiven;

	}

	// Affiche les stats
	@Override
	public String toString() {
		return "\n\n------------- " + name + " -------------\n\n pvMax : " + pvMax + "\t\t pv: " + pv + "/" + pvMax + "\n sTr: "
				+ sTr + "\t\t mag: " + mag + "\n pDef: " + pDef + "\t\t mDef: " + mDef + "\n con: " + con;
	}

	public void dropLoot(Player p) {

		if (Player.randomNumber(1, 100) <= loot.getTauxDrop()) {

			System.out.println(
					"\nEn fouillant le corps du " + name.toLowerCase() + ", " + p.getName() + " trouve: " + loot.getNom());
			p.getInventaire().ajouter(loot);

		}

	}

	@Override
	public boolean do_p_dmg(Player ennemy) {

		Integer randDmg = Player.randomNumber(1, 3);
		Integer dmg = this.sTr - ennemy.getpDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("\n" + ennemy.getName() + " a évité l'attaque de " + this.name);
		} else {
			System.out.println("\n" + this.name + " a infligé " + dmg + " dégats à " + ennemy.getName() + " !");
		}

		return ennemy.getPv() <= 0;

	}

	@Override
	public boolean do_m_dmg(Player ennemy) {

		Integer randDmg = Player.randomNumber(1, 3);
		Integer dmg = this.mag - ennemy.getmDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("\n" + ennemy.getName() + " a évité le sort de " + this.name);
		} else {
			System.out.println("\n" + this.name + " a infligé " + dmg + " dégats à " + ennemy.getName() + " !");
		}

		return ennemy.getPv() <= 0;

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

	public Carriable getLoot() {
		return loot;
	}

	public void setLoot(Carriable loot) {
		this.loot = loot;
	}

	public Integer getXpGiven() {
		return xpGiven;
	}

	public void setXpGiven(Integer xpGiven) {
		this.xpGiven = xpGiven;
	}

}
