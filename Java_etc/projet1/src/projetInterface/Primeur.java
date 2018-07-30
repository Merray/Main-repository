package projetInterface;

public class Primeur extends Article implements Kilo, Piece, Descriptable{
	int stock;
	
	public Primeur(double prixAchat, double prixVente, String nom, String fournisseur) {
		super(prixAchat, prixVente, nom, fournisseur);
		this.stock = 0;
	}
	
	
	public void remplirStock(int nombre) {
		stock += nombre;
	}


	@Override
	public String toString() {
		return "Primeur [stock=" + stock + ", prixAchat=" + prixAchat + ", prixVente=" + prixVente + ", nom=" + nom
				+ ", fournisseur=" + fournisseur + ", rendement : "+ this.tauxRendement() +"]";
	}


	@Override
	public void desc() {
		System.out.println();
		System.out.println("------------ Mon Primeur ------------\n\n"
				+ "Nom: "+ nom + "\n" 
				+ "Prix d'achat: "+ prixAchat + "\n" 
				+ "Prix de revente: "+ prixVente + "\n"
				+ "Stock: "+ stock + "\n"
				+ "Fournisseur: "+ fournisseur + "\n"
				+ "Rendement : "+ tauxRendement()+ "\n\n-------------------------------------");
		
	}
	
	
	@Override
	public double vendrePiece(int quantite) {
		stock -= quantite;
		return quantite*prixVente;
	}


	@Override
	public double vendreKilo(double quantite) {
		stock -= quantite;
		return quantite*prixVente;
	}
	
	
	
	
	
	
	
	
	
	
	
}
