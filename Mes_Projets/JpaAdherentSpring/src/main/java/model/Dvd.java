package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dvd extends Article{
	
	@Column(name="bonus")
	private Boolean bonus;

	public Dvd() {
		super();
	}
	

	/**
	 * @param nbDisques
	 * @param emprunteur
	 * @param film
	 */
	public Dvd(Integer nbDisques, Adherent emprunteur, Film film, Boolean bonus) {
		super(nbDisques, emprunteur, film);
		this.bonus = bonus;
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param numeroArticle
	 * @param nbDisques
	 */
	public Dvd(Integer numeroArticle, Integer nbDisques) {
		super(numeroArticle, nbDisques);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param nbDisques
	 */
	public Dvd(Integer nbDisques) {
		super(nbDisques);
		// TODO Auto-generated constructor stub
	}


	public Dvd(Integer nbDisques, Boolean bonus) {
		super(nbDisques);
		this.bonus = bonus;
	}

	public Boolean getBonus() {
		return bonus;
	}

	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}
	
	
	

}
