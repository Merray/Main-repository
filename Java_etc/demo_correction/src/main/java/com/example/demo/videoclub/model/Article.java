package com.example.demo.videoclub.model;

import javax.persistence.*;

import com.example.demo.videoclub.model.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "seqArticle", sequenceName = "seq_article", initialValue = 1, allocationSize = 1)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Dvd.class, name = "D"), @Type(value = Blueray.class, name = "B") })
public abstract class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
	@Column(name = "id_article")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Version
	private int version;
	@Column(name = "nb_disques")
	@JsonView(JsonViews.Common.class)
	private Integer nbDisques;
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent emprunteur;
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;

	public Article() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
