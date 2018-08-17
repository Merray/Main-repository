package src.main.java.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="realisateur")
@SequenceGenerator(name="seqRealisateur", sequenceName="seq_realisateur", initialValue=50, allocationSize=1)


public class Realisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRealisateur")
	@Column(name="id_realisateur")
	private Integer id;
	@Column(name="first_name", nullable=false, length=150)
	private String prenom;
	@Column(name="last_name", nullable=true, length=150)
	private String nom;

	
	
	public Realisateur() {
		
		
	}

	public Realisateur(String nom, String prenom ) {
		this.nom = nom;
		this.prenom = prenom;
		
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realisateur other = (Realisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Realisateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}





	
	
}
