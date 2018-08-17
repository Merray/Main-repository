package equipements;

public enum Materiaux {

	TISSU1("Tissu",1), TISSU2("Tissu",2), CUIR1("Cuir", 1), CUIR2("Cuir", 2);
	
	private String nom;
	private Integer quantite;
	
	private Materiaux(String nom, Integer quantite) {
		this.nom = nom;
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	
	
	
	
}
