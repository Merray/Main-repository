package com.example.demo.videoclub.model;

import javax.persistence.*;

import com.example.demo.videoclub.model.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@JsonView(JsonViews.Common.class)
	@Column(name = "numero")
	private Integer numero;
	@JsonView(JsonViews.Common.class)
	@Column(name = "rue", length = 150)
	private String rue;
	@JsonView(JsonViews.Common.class)
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
