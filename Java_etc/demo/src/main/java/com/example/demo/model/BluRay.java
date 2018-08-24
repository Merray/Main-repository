package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BluRay extends Article {
	@Column(name="trois_d")
	private Boolean troisD;

	public BluRay() {
	}



	/**
	 * @param nbDisques
	 * @param emprunteur
	 * @param film
	 */
	public BluRay(Integer nbDisques, Adherent emprunteur, Film film, Boolean troiD) {
		super(nbDisques, emprunteur, film);
		this.troisD = troiD;
	}



	/**
	 * @param numeroArticle
	 * @param nbDisques
	 */
	public BluRay(Integer numeroArticle, Integer nbDisques) {
		super(numeroArticle, nbDisques);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param nbDisques
	 */
	public BluRay(Integer nbDisques) {
		super(nbDisques);
		// TODO Auto-generated constructor stub
	}



	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}

	
}
