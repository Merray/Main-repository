package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="street", length=255)
	private String rue;
	@Column(name="zip_code", length=6)
	private Integer cp;
	@Column(name="city", length=150)
	private String ville;
	
	
	public Adresse() {
	
	}


	public Adresse(String rue, Integer cp, String ville) {
		super();
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public Integer getCp() {
		return cp;
	}


	public void setCp(Integer cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	
}
