package equipements;

import java.util.List;

import persos.Player;

public enum MainDroite implements Equipement {

	EPEE_ROUILLEE("Epée rouillée", 1,0), EPEE_EN_BON_ETAT("Epée en bon état", 3,0);
	private String nom;
	private Integer modifFor;
	private Integer modifMag;

	private MainDroite(String nom, Integer modifFor, Integer modifMag) {
		this.nom = nom;
		this.modifFor = modifFor;
		this.modifMag = modifMag;
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

}
