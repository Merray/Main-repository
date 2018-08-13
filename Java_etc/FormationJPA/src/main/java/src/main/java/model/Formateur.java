package src.main.java.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class Formateur extends Personne{

	@Column(name="experience")
	private Integer anneeExperience;
	
	public Formateur() {
		super();
		
	}


	public Formateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Formateur(String nom, String prenom, Integer anneeExperience) {
		super(nom, prenom);
		this.anneeExperience = anneeExperience;
	}





	public Integer getAnneeExperience() {
		return anneeExperience;
	}


	public void setAnneeExperience(Integer anneeExperience) {
		this.anneeExperience = anneeExperience;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((anneeExperience == null) ? 0 : anneeExperience.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formateur other = (Formateur) obj;
		if (anneeExperience == null) {
			if (other.anneeExperience != null)
				return false;
		} else if (!anneeExperience.equals(other.anneeExperience))
			return false;
		return true;
	}

	
}
