package videoclub.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name = "seqAdherent", sequenceName = "seq_adherent", initialValue = 1, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="findAdherentByVille",query="select adh from Adherent adh where lower(adh.adresse.ville) like :maville")
})
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdherent")
	@Column(name = "id_adherent")
	private Integer id;
	@Version
	private int version;
	@Column(name = "prenom", length = 50)
	private String prenom;
	@Column(name = "nom", length = 50)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilité", length = 5)
	private Civilite civilite;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "emprunteur", fetch = FetchType.LAZY)
	private Set<Article> articlesEmpruntes;

	public Adherent() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adherent other = (Adherent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Article> getArticlesEmpruntes() {
		return articlesEmpruntes;
	}

	public void setArticlesEmpruntes(Set<Article> articlesEmpruntes) {
		this.articlesEmpruntes = articlesEmpruntes;
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + "]";
	}

}
