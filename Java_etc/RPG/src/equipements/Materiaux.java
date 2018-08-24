package equipements;

public enum Materiaux implements Carriable {

	TISSU1("Tissu", 1, 25), TISSU2("Tissu", 2, 10), CUIR1("Cuir", 1,15), CUIR2("Cuir", 2,8), FER1("Fer", 1, 12), FER2("Fer", 2, 5);

	private String nom;
	private Integer quantite;
	private Integer tauxDrop;

	private Materiaux(String nom, Integer quantite, Integer tauxDrop) {
		this.nom = nom;
		this.quantite = quantite;
		this.tauxDrop = tauxDrop;
	}

	public Integer getTauxDrop() {
		return tauxDrop;
	}

	public void setTauxDrop(Integer tauxDrop) {
		this.tauxDrop = tauxDrop;
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
	
	@Override
	public int compareTo(Carriable objet) {
		if (this.getNom().compareTo(objet.getNom()) <0) {
			return -1;
		} else if (this.getNom().compareTo(objet.getNom()) >0) {
			return 1;
		} else {
			
		return 0;
		}
	}

}
