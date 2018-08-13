package model;

public abstract class Article {
	private Integer numeroArticle;
	private Integer nbDisques;
	private Adherent emprunteur;

	public Article() {
	}

	/**
	 * @param numeroArticle
	 * @param nbDisques
	 */
	public Article(Integer numeroArticle, Integer nbDisques) {
		this.numeroArticle = numeroArticle;
		this.nbDisques = nbDisques;
	}

	/**
	 * @param nbDisques
	 */
	public Article(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Integer getNumeroArticle() {
		return numeroArticle;
	}

	public void setNumeroArticle(Integer numeroArticle) {
		this.numeroArticle = numeroArticle;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	

}
