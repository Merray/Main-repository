package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Stagiaire extends Personne {
	@Column(name = "company", length = 100)
	private String entreprise;

	public Stagiaire() {
		super();
	}

	public Stagiaire(String prenom, String nom) {
		super(prenom, nom);
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

}
