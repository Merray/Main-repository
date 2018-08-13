package src.main.java.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=2)
@SequenceGenerator(name="seqPersonne", sequenceName="seq_person", initialValue=50, allocationSize=1)


public class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPersonne")
	@Column(name="id_person")
	private Integer id;
	@Column(name="first_name", nullable=false, length=150)
	@NotNull(message="Le prenom ne peut pas être vide")
	@Length(min=3, message="3 caractères minimum pour le prenom")
	private String prenom;
	@Column(name="last_name", nullable=true, length=150)
	private String nom;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="rue", column=@Column(name="street_person",length=255)),
		@AttributeOverride(name="cp", column=@Column(name="zip_code_person", length=6)),
		@AttributeOverride(name="ville", column=@Column(name="cityçperson", length=150))
	})
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name= "classroom_id")
	private Salle salle;
	@Version
	private int version;
	
	public Personne() {
		
		
	}

	public Personne(String nom, String prenom) {
		
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


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Personne other = (Personne) obj;
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
		return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	
	
}
