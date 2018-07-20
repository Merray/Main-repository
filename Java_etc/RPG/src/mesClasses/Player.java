package mesClasses;

public class Player extends Character{
	
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
		return "\n---------- "+ name + " ----------\n\n pvMax : " + pvMax + "\t pv: " + pv + "/" + pvMax +"\n sTr: " + sTr + "\t\t mag: " + mag + "\n pDef: " + pDef
				+ "\t mDef: " + mDef + "\n con: " + con + "\t\t pd: "+ pd;
	}
	
}
