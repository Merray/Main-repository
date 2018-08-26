package equipements;

import java.util.List;

import persos.Player;

public enum MainDroite implements Equipement {

	EPEE_ROUILLEE("Epée rouillée", 1, 0, 65, 1), EPEE_EN_BON_ETAT("Epée en bon état", 3, 0, 25, 1),
	MJOLNIR("Mjolnir", 5, 0, 25, 1), BAGUETTE_BAS_DE_GAMME("Baguette bas de gamme", 0, 1, 50, 1),
	BAGUETTE_ROI_MAGE("Baguette Roi Mage", 0, 8, 10, 1);
	private String nom;
	private Integer modifFor;
	private Integer modifMag;
	private Integer tauxDrop;
	private Integer quantite;

	private MainDroite(String nom, Integer modifFor, Integer modifMag, Integer tauxDrop, Integer quantite) {
		this.nom = nom;
		this.modifFor = modifFor;
		this.modifMag = modifMag;
		this.tauxDrop = tauxDrop;
		this.quantite = quantite;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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

	@Override
	public void afficher() {
		// TODO Auto-generated method stub

	}

	@Override
	public Equipement ameliorer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materiaux> scrap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void equiper(Player player) {
		this.retirer(player);
		player.setMainDroite(this);
		this.setStats(player);

	}

	public void retirer(Player player) {
		if (player.getMainDroite() != null) {
			player.getMainDroite().removeStats(player);
			player.setMainDroite(null);
		}
	}

	@Override
	public void setStats(Player player) {
		player.setsTr(player.getsTr() + this.modifFor);
		player.setMag(player.getMag() + this.modifMag);

	}

	@Override
	public void removeStats(Player player) {
		player.setsTr(player.getsTr() - this.modifFor);
		player.setMag(player.getMag() - this.modifMag);

	}

	@Override
	public int compareTo(Carriable objet) {
		if (this.getNom().compareTo(objet.getNom()) < 0) {
			return -1;
		} else if (this.getNom().compareTo(objet.getNom()) > 0) {
			return 1;
		} else {

			return 0;
		}
	}

}
