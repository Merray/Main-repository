package persos;

public enum Monster implements Attacker<Player> {

	CHTULHU("Chtulhu", 100, 15, 12, 7, 12, 5), GOBELIN("Gobelin", 10, 2, 0, 0, 0, 1),
	GOBELIN_MAGE("Gobelin mage", 8, 0, 2, 0, 0, 1), GOBELIN_CUIRASSE("Gobelin cuirassé", 12, 3,0,2,0,2);

	private String name;
	private Integer pvMax, pv, sTr, mag, pDef, mDef, con;

	private Monster(String name, Integer pvMax, Integer sTr, Integer mag, Integer pDef, Integer mDef, Integer con) {

		this.name = name;
		this.pvMax = pvMax;
		pv = pvMax;
		this.sTr = sTr;
		this.mag = mag;
		this.pDef = pDef;
		this.mDef = mDef;
		this.con = con;
	}
	
	// Affiche les stats
	@Override
	public String toString() {
		return "\n\n---------- " + name + " ----------\n\n pvMax : " + pvMax + "\t pv: " + pv + "/" + pvMax + "\n sTr: "
				+ sTr + "\t\t mag: " + mag + "\n pDef: " + pDef + "\t mDef: " + mDef + "\n con: " + con;
	}

	@Override
	public boolean do_p_dmg(Player ennemy) {

		Integer randDmg = Player.randomNumber(1, 3);
		Integer dmg = this.sTr - ennemy.getpDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("\n"+this.name +" a évité l'attaque de " + ennemy.getName());
		} else {
			System.out.println(dmg + " dégats!");
		}

		return ennemy.getPv() <= 0;

	}

	@Override
	public boolean do_m_dmg(Player ennemy) {

		Integer randDmg = Player.randomNumber(1, 3);
		Integer dmg = this.mag - ennemy.getmDef() + randDmg;

		ennemy.setPv(ennemy.getPv() - dmg);

		if (dmg <= 0) {
			System.out.println("Evité!");
		} else {
			System.out.println(dmg + " dégats!");
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

}
