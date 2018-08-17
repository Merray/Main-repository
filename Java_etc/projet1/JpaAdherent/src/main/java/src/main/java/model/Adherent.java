package src.main.java.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.persistence.Version;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name = "seqAdherent", sequenceName = "seq_adherent", initialValue = 50, allocationSize = 1)
@NamedQueries({
	
	@NamedQuery(name="Adherent.findByCity", query="select a from Adherent a where a.adresse.ville like :ville")
	
})

public class Adherent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdherent")
	@Column(name = "id_adherent")
	private Integer id;
	@Column(name = "civilite", length = 5)
	private String civilite;
	@Column(name = "first_name", nullable = false, length = 150)
	private String prenom;
	@Column(name = "last_name", nullable = true, length = 150)
	private String nom;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "street_adherent", length = 255)),
			@AttributeOverride(name = "cp", column = @Column(name = "zip_code_adherent", length = 6)),
			@AttributeOverride(name = "ville", column = @Column(name = "city_adherent", length = 150)) })
	private Adresse adresse;
	@OneToMany(mappedBy = "emprunteur", fetch = FetchType.LAZY)
	private Set<Article> articles;
	@Version
	private int version;

	public Adherent() {

	}

	public Adherent(String civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;

		
		
	}
	
	

	public Adherent(String civilite, String prenom, String nom, Adresse adresse, Set<Article> articles) {
		super();
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.articles = articles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
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

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
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
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
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
		Adherent other = (Adherent) obj;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
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
		return "Adherent [id=" + id + ", civilite=" + civilite + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

}
