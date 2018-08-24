package com.example.demo.videoclub.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "film")
@SequenceGenerator(name = "seqFilm", sequenceName = "seq_film", initialValue = 1, allocationSize = 1)
public class Film {
	@Id
	@Column(name = "id_film")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFilm")
	private Integer id;
	@Version
	private int version;
	@Column(name = "titre", length = 150)
	private String titre;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_sortie")
	private Date dateSortie;
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	private Set<Article> articles;
	@OneToMany(mappedBy="key.film")
	private Set<FilmRealisateur> realisateurs;

	public Film() {
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
		Film other = (Film) obj;
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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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

	public Set<FilmRealisateur> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(Set<FilmRealisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

}
