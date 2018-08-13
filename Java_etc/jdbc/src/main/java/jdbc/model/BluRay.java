package jdbc.model;

public class BluRay extends Article {
	
	private Boolean troisD;

	public BluRay() {
	}

	public BluRay(Integer numeroArticle, Integer nbDisques, Boolean troisD) {
		super(numeroArticle, nbDisques);
		this.troisD = troisD;
	}

	public BluRay(Integer nbDisques, Boolean troisD) {
		super(nbDisques);
		this.troisD = troisD;
	}

	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}

	
}
