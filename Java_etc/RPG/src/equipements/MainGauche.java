package equipements;

import java.util.List;

import persos.Player;

public enum MainGauche implements Equipement {

	BOUCLIER_EN_BOIS("Bouclier en bois", 0, 0, 1, 0, 50, 1), BOUCLIER_EN_FER("Bouclier en fer", 1, 0, 1, 0, 15, 1);

	private String nom;
	private Integer modifFor;
	private Integer modifMag;
	private Integer modifPDef;
	private Integer modifMDef;
	private Integer tauxDrop;
	private Integer quantite;

	private MainGauche(String nom, Integer modifFor, Integer modifMag, Integer modifPDef, Integer modifMDef,
			Integer tauxDrop, Integer quantite) {
		this.nom = nom;
		this.modifFor = modifFor;
		this.modifMag = modifMag;
		this.modifPDef = modifPDef;
		this.modifMDef = modifMDef;
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
		player.setMainGauche(this);
		this.setStats(player);

	}

	public void retirer(Player player) {
		if (player.getMainGauche() != null) {
			player.getMainGauche().removeStats(player);
			player.setMainGauche(null);
		}
	}

	@Override
	public void setStats(Player player) {
		player.setsTr(player.getsTr() + this.modifFor);
		player.setMag(player.getMag() + this.modifMag);
		player.setpDef(player.getpDef() + this.modifPDef);
		player.setmDef(player.getmDef() + this.modifMDef);

	}

	@Override
	public void removeStats(Player player) {
		player.setsTr(player.getsTr() - this.modifFor);
		player.setMag(player.getMag() - this.modifMag);
		player.setpDef(player.getpDef() - this.modifPDef);
		player.setmDef(player.getmDef() - this.modifMDef);

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
