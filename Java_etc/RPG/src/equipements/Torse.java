package equipements;

import java.util.List;

import persos.Player;

public enum Torse implements Equipement {

	GILET("Gilet", 1, 1, 0, 70, 1), ARMURE_DE_CUIR("Armure de cuir", 2, 0, 1, 25, 1),
	ROBE_DE_CHAMBRE("Robe de chambre", 0, 0, 0, 75, 1), DECOLLETE_SEXY("Décolleté sexy", 5, 2, 5, 10, 1);

	private String nom;
	private Integer modifPDef;
	private Integer modifMDef;
	private Integer modifCon;
	private Integer tauxDrop;
	private Integer quantite;

	private Torse(String nom, Integer modifPDef, Integer modifMDef, Integer modifCon, Integer tauxDrop,
			Integer quantite) {
		this.nom = nom;
		this.modifPDef = modifPDef;
		this.modifMDef = modifMDef;
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

	public Integer getModifCon() {
		return modifCon;
	}

	public void setModifCon(Integer modifCon) {
		this.modifCon = modifCon;
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
		player.setTorse(this);
		this.setStats(player);

	}

	public void retirer(Player player) {
		if (player.getTorse() != null) {
			player.getTorse().removeStats(player);
			player.setTorse(null);
		}
	}

	@Override
	public void setStats(Player player) {
		player.setpDef(player.getpDef() + this.modifPDef);
		player.setmDef(player.getmDef() + this.modifMDef);
		player.setCon(player.getCon() + this.modifCon);

	}

	@Override
	public void removeStats(Player player) {
		player.setpDef(player.getpDef() - this.modifPDef);
		player.setmDef(player.getmDef() - this.modifMDef);
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
