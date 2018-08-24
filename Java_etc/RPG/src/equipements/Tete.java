package equipements;

import java.util.List;

import persos.Player;

public enum Tete implements Equipement {

	CASQUE_ROUILLE("Casque rouill�", 0, 0, 1, 15, 1), CASQUE_DE_FER("Casque de fer", 1, 0, 2, 10, 1);

	private String nom;
	private Integer modifFor;
	private Integer modifMag;
	private Integer modifCon;
	private Integer tauxDrop;
	private Integer quantite;

	private Tete(String nom, Integer modifFor, Integer modifMag, Integer modifCon, Integer tauxDrop, Integer quantite) {
		this.nom = nom;
		this.modifFor = modifFor;
		this.modifMag = modifMag;
		this.modifCon = modifCon;
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

	public Integer getModifCon() {
		return modifCon;
	}

	public void setModifCon(Integer modifCon) {
		this.modifCon = modifCon;
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
		player.setTete(this);
		this.setStats(player);

	}

	public void retirer(Player player) {
		if (player.getTete() != null) {
			player.getTete().removeStats(player);
			player.setTete(null);
		}
	}

	@Override
	public void setStats(Player player) {
		player.setsTr(player.getsTr() + this.modifFor);
		player.setMag(player.getMag() + this.modifMag);
		player.setCon(player.getCon() + this.modifCon);

	}

	@Override
	public void removeStats(Player player) {
		player.setsTr(player.getsTr() - this.modifFor);
		player.setMag(player.getMag() - this.modifMag);
		player.setCon(player.getCon() - this.modifCon);
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
