package src.main.java.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Stagiaire extends Personne {

	private Integer anneeEtudes;
	
	public Stagiaire() {
		super();
	}

	public Stagiaire(String nom, String prenom) {
		super(nom, prenom);
	}
	public Stagiaire(String nom, String prenom, Integer anneeEtude) {
		super(nom, prenom);
		this.anneeEtudes = anneeEtude;
	}

	public Integer getAnneeEtudes() {
		return anneeEtudes;
	}

	public void setAnneeEtudes(Integer anneeEtudes) {
		this.anneeEtudes = anneeEtudes;
	}

	
}
