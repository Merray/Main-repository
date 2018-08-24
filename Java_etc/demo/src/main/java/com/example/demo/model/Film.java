package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="movie")
@SequenceGenerator(name="seqFilm", sequenceName="seq_movie", initialValue=50, allocationSize=1)
public class Film {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqFilm")
	@Column(name="id_movie")
	private Integer id;
	@Column(name="name")
	private String titre;
	@Column(name="realease_date")
	private Date dateSortie;
	@OneToMany(mappedBy="film", fetch=FetchType.LAZY)
	private Set<Article> articles;
	@Version
	private int version;
	
	public Film() {
	
	}

	public Film(String titre, Date dateSortie, Set<Article> articles) {
		super();
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.articles = articles;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

}
