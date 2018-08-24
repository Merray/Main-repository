package com.example.demo.videoclub.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.videoclub.model.views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name = "seqAdherent", sequenceName = "seq_adherent", initialValue = 1, allocationSize = 1)
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdherent")
	@Column(name = "id_adherent")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Version
	private int version;
	@Column(name = "prenom", length = 50)
	@NotEmpty
	@Length(min = 3, max = 50)
	@JsonView(JsonViews.Common.class)
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_naissance")
	@JsonView(JsonViews.Common.class)
	private Date dateNaissance;
	@Embedded
	@JsonView(JsonViews.Common.class)
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
	public String getDescription() {
		return this.prenom + " " + this.nom;
	}

	public Set<Article> getArticlesEmpruntes() {
		return articlesEmpruntes;
	}

	public void setArticlesEmpruntes(Set<Article> articlesEmpruntes) {
		this.articlesEmpruntes = articlesEmpruntes;
	}
}
