package equipements;

import java.util.List;

import persos.Player;

public enum Jambes implements Equipement {

	CALECON("Caleçon", 0, 1, 90, 1), PANTALON_EN_CUIR("Pantalon en cuir", 1, 1, 65, 1),
	PANTALON_COMBI_CONTRE_LE_FROID("Pantalon combi contre le froid", 1, 0, 55, 1),
	CULOTTE_ELEGANTE("Culotte élégante", 0, 0, 85, 1);

	private String nom;
	private Integer modifPDef;
	private Integer modifCon;
	private Integer tauxDrop;
	private Integer quantite;

	private Jambes(String nom, Integer modifPDef, Integer modifCon, Integer tauxDrop, Integer quantite) {
		this.nom = nom;
		this.modifPDef = modifPDef;
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
		player.setJambes(this);
		this.setStats(player);

	}

	public void retirer(Player player) {
		if (player.getJambes() != null) {
			player.getJambes().removeStats(player);
			player.setJambes(null);
		}
	}

	@Override
	public void setStats(Player player) {
		player.setpDef(player.getpDef() + this.modifPDef);
		player.setCon(player.getCon() + this.modifCon);

	}

	@Override
	public void removeStats(Player player) {
		player.setpDef(player.getpDef() - this.modifPDef);
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
