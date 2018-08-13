package src.main.java.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
@SequenceGenerator(name="seqSalle", sequenceName= "seq_classrooom", initialValue=50, allocationSize=1)
@NamedQueries({
	@NamedQuery(name="Salle.findAllWithPersonnes", query="select distinct s from Salle s left join fetch s.personnes")
	
})

public class Salle {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSalle")
	@Column(name="id_salle")
	private Integer numero;	
	@Column(name="name")
	private String nom;
	@Column(name="floor")
	private Integer etage;
	@OneToMany(mappedBy="salle", fetch=FetchType.LAZY)
	private Set<Personne> personnes;
	
	public Salle() {
		
	}

	public Salle(String nom, Integer etage) {
		super();
		this.nom = nom;
		this.etage = etage;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getEtage() {
		return etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etage == null) ? 0 : etage.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Salle other = (Salle) obj;
		if (etage == null) {
			if (other.etage != null)
				return false;
		} else if (!etage.equals(other.etage))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	

}
