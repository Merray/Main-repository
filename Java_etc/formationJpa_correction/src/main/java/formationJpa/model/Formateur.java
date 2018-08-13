package formationJpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class Formateur extends Personne {
	@Column(name = "experience")
	private Integer anneeExperience;

	public Formateur() {
		super();
	}

	public Formateur(String prenom, String nom) {
		super(prenom, nom);
		// TODO Auto-generated constructor stub
	}

	public Integer getAnneeExperience() {
		return anneeExperience;
	}

	public void setAnneeExperience(Integer anneeExperience) {
		this.anneeExperience = anneeExperience;
	}

}
