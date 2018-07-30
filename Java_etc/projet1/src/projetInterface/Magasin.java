package projetInterface;

import java.util.Arrays;

public class Magasin implements Descriptable, Rendement{
	double depenses;
	double revenus;
	Electro eTab [];
	Primeur pTab [];

	public Magasin(double depenses, double revenus, Electro[] eTab, Primeur[] pTab) {
		this.depenses = depenses;
		this.revenus = revenus;
		this.eTab = eTab;
		this.pTab = pTab;
	}
	
	
	public double tauxRendement() {
		return (revenus-depenses)/depenses;
	}


	@Override
	public String toString() {
		return "Magasin [depenses=" + depenses + ", revenus=" + revenus + ", eTab=" + Arrays.toString(eTab) + ", pTab="
				+ Arrays.toString(pTab) + ", rendement=" + tauxRendement() + "]";
	}


	@Override
	public void desc() {
		System.out.println();
		System.out.println("------------ Mon Magasin ------------\n\n"
				+ "Dépenses: "+ depenses + "\n" 
				+ "Revenus: "+ revenus + "\n"
				+ "Electroménager: "+ eTab + "\n"
				+ "Primeur: "+ pTab + "\n"
				+ "Rendement : "+ tauxRendement()+ "\n\n-------------------------------------");
		
	}
	
	
	
	
}
