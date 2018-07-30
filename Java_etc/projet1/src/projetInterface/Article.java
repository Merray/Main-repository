package projetInterface;

public class Article implements Rendement{
	
	double prixAchat;
	double prixVente;
	String nom;
	String fournisseur;
	
	public Article(double prixAchat, double prixVente, String nom, String fournisseur){
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.nom = nom;
		this.fournisseur = fournisseur;
	}
	
	public double tauxRendement() {
		
		return (prixVente - prixAchat)/prixAchat;
	}

	@Override
	public String toString() {
		return "Article [prixAchat=" + prixAchat + ", prixVente=" + prixVente + ", nom=" + nom + ", fournisseur="
				+ fournisseur + ", rendement : "+ this.tauxRendement()  + "]";
	}
	
	
	
}
