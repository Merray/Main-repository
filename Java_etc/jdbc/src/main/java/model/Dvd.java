package model;

public class Dvd extends Article {

	private Boolean bonus;

	/**
	 * 
	 */
	public Dvd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numeroArticle
	 * @param nbDisques
	 */
	public Dvd(Integer numeroArticle, Integer nbDisques, Boolean bonus) {
		super(numeroArticle, nbDisques);
		this.bonus = bonus;
	}

	/**
	 * @param nbDisques
	 */
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
