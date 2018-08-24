package com.example.demo.videoclub.model;

import javax.persistence.*;

@Entity
@Table(name = "film_realisateur")
public class FilmRealisateur {
	@EmbeddedId
	private FilmRealisateurPK key;

	public FilmRealisateurPK getKey() {
		return key;
	}

	public void setKey(FilmRealisateurPK key) {
		this.key = key;
	}
	
}
