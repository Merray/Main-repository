package com.example.demo.videoclub.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.videoclub.model.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name = "seqAdherent", sequenceName = "seq_adherent", initialValue = 1, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "findAdherentByVille", query = "select adh from Adherent adh where lower(adh.adresse.ville) like :maville") })
public class Adherent {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdherent")
	@Column(name = "id_adherent")
	private Integer id;
	@Version
	private int version;
	@JsonView(JsonViews.Common.class)
	@Column(name = "prenom", length = 50)
	@NotEmpty
	@Length(min = 3, max = 50)
	private String prenom;
	@Column(name = "nom", length = 50)
	@NotEmpty
	@Length(min = 3, max = 50)
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilit�", length = 5)
	@JsonView(JsonViews.Common.class)
	private Civilite civilite;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateNaissance;
	@Embedded
	@JsonView(JsonViews.Common.class)
	private Adresse adresse;
	@OneToMany(mappedBy = "emprunteur", fetch = FetchType.LAZY)
	@JsonView(JsonViews.AdherentWithArticles.class)
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setArticlesEmpruntes(Set<Article> articlesEmpruntes) {
		this.articlesEmpruntes = articlesEmpruntes;
	}

	public String getDescription() {
		return id + " " + prenom + " " + nom;
	}

}
