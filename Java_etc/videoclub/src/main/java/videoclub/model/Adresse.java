package videoclub.model;

import javax.persistence.*;

@Embeddable
public class Adresse {
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "rue", length = 150)
	private String rue;
	@Column(name = "ville", length = 50)
	private String ville;

	public Adresse() {
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
