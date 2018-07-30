package projetInterface;

public class monMagasin {

	public static void main(String[] args) {
		
		Electro eTab [] = new Electro[2];
		
		eTab[0] = new Electro(200, 450, "Turbomix2000", "Bosh");
		eTab[0].remplirStock(2);
		
		eTab[1] = new Electro(100, 400, "Supercuiseur", "Four&Co");
		eTab[1].remplirStock(1);
		
		
		
		Primeur pTab [] = new Primeur[2];
		
		pTab[0] = new Primeur(1.10, 2.50, "Pommes pas bonnes", "Green Lady");
		pTab[0].remplirStock(10);
		
		pTab[1] = new Primeur(1.20, 5.50, "Cerises", "Cerises&Co");
		pTab[1].remplirStock(15);
		
		
		Magasin monMagasin = new Magasin(150, 375, eTab, pTab);
		
		monMagasin.desc();
		eTab[0].desc();
		//pTab[0].desc();
		
		
		System.out.println("\nC'EST LES SOLDES !!! -20% SUR TOUS LES TURBOMIX2000 !!!!!!!");
		eTab[0].soldeOn(20);
		eTab[0].desc();
		
		eTab[0].soldeOff(20);
		eTab[0].desc();
	}

}
