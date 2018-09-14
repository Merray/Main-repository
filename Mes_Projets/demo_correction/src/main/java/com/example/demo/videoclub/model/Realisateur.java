package com.example.demo.videoclub.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "realisateur")
@SequenceGenerator(name = "seqRealisateur", sequenceName = "seq_realisateur", initialValue = 1, allocationSize = 1)
public class Realisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRealisateur")
	@Column(name = "id_realisateur")
	private Integer id;
	@Version
	private int version;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	@OneToMany(mappedBy="key.realisateur")
	private Set<FilmRealisateur> films;

	public Realisateur() {
	}

	@Override
	public String toString() {
		return "Realisateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
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
		Realisateur other = (Realisateur) obj;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<FilmRealisateur> getFilms() {
		return films;
	}

	public void setFilms(Set<FilmRealisateur> films) {
		this.films = films;
	}

}
