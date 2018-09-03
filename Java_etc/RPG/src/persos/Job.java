package persos;

public enum Job {

	GUERRIER("Guerrier", 15, 6, 0, 3, 1, 4, 5, 3, 1, 1, 1, 2), MAGE("Mage", 10, 1, 5, 1, 3, 2, 2, 1, 3, 0, 1, 2),
	PALADIN("Paladin", 14, 4, 3, 2, 2, 3, 4, 2, 2, 1, 1, 1);

	private String name;
	private Integer basePv;
	private Integer baseFor;
	private Integer baseMag;
	private Integer basePDef;
	private Integer baseMDef;
	private Integer baseCon;
	private Integer modifPv;
	private Integer modifFor;
	private Integer modifMag;
	private Integer modifPDef;
	private Integer modifMDef;
	private Integer modifCon;

	private Job(String name, Integer basePv, Integer baseFor, Integer baseMag, Integer basePDef, Integer baseMDef,
			Integer baseCon, Integer modifPv, Integer modifFor, Integer modifMag, Integer modifPDef, Integer modifMDef,
			Integer modifCon) {
		this.name = name;
		this.basePv = basePv;
		this.baseFor = baseFor;
		this.baseMag = baseMag;
		this.basePDef = basePDef;
		this.baseMDef = baseMDef;
		this.baseCon = baseCon;
		this.modifPv = modifPv;
		this.modifFor = modifFor;
		this.modifMag = modifMag;
		this.modifPDef = modifPDef;
		this.modifMDef = modifMDef;
		this.modifCon = modifCon;
	}

	public void boostStats(Player p) {

		p.setPvMax(p.getPvMax() + this.modifPv + (p.getCon() / 2));
		p.setPv(p.getPvMax());
		p.setsTr(p.getsTr() + modifFor);
		p.setMag(p.getMag() + modifMag);
		p.setpDef(p.getpDef() + modifPDef);
		p.setmDef(p.getmDef() + modifMDef);
		p.setCon(p.getCon() + modifCon);

		System.out.println("\n+--------------------+");
		System.out.println("|     Pv : +" + (((modifPv) + (p.getCon() / 2)) - 1) + "       |");
		System.out.println("|     For : +" + modifFor + "       |");
		System.out.println("|     Mag : +" + modifMag + "       |");
		System.out.println("|     pDef : +" + modifPDef + "      |");
		System.out.println("|     mDef : +" + modifMDef + "      |");
		System.out.println("|     Con : +" + modifCon + "       |");
		System.out.println("+--------------------+");
	}

	public Integer getBasePv() {
		return basePv;
	}

	public void setBasePv(Integer basePv) {
		this.basePv = basePv;
	}

	public Integer getModifPv() {
		return modifPv;
	}

	public void setModifPv(Integer modifPv) {
		this.modifPv = modifPv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseFor() {
		return baseFor;
	}

	public void setBaseFor(Integer baseFor) {
		this.baseFor = baseFor;
	}

	public Integer getBaseMag() {
		return baseMag;
	}

	public void setBaseMag(Integer baseMag) {
		this.baseMag = baseMag;
	}

	public Integer getBasePDef() {
		return basePDef;
	}

	public void setBasePDef(Integer basePDef) {
		this.basePDef = basePDef;
	}

	public Integer getBaseMDef() {
		return baseMDef;
	}

	public void setBaseMDef(Integer baseMDef) {
		this.baseMDef = baseMDef;
	}

	public Integer getBaseCon() {
		return baseCon;
	}

	public void setBaseCon(Integer baseCon) {
		this.baseCon = baseCon;
	}

	public Integer getModifFor() {
		return modifFor;
	}

	public void setModifFor(Integer modifFor) {
		this.modifFor = modifFor;
	}

	public Integer getModifMag() {
		return modifMag;
	}

	public void setModifMag(Integer modifMag) {
		this.modifMag = modifMag;
	}

	public Integer getModifPDef() {
		return modifPDef;
	}

	public void setModifPDef(Integer modifPDef) {
		this.modifPDef = modifPDef;
	}

	public Integer getModifMDef() {
		return modifMDef;
	}

	public void setModifMDef(Integer modifMDef) {
		this.modifMDef = modifMDef;
	}

	public Integer getModifCon() {
		return modifCon;
	}

	public void setModifCon(Integer modifCon) {
		this.modifCon = modifCon;
	}

}
