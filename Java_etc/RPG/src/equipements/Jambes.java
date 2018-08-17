package equipements;

import java.util.List;

import persos.Player;

public enum Jambes implements Equipement {

	CALECON("Caleçon", 0,1), PANTALON_EN_CUIR("Pantalon en cuir", 1,1);
	
	private String nom;
	private Integer modifPDef;
	private Integer modifCon;

	private Jambes(String nom, Integer modifPDef, Integer modifCon) {
		this.nom = nom;
		this.modifPDef = modifPDef;
		this.modifCon = modifCon;
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

}
