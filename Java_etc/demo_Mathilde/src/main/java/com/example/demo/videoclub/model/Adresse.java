package com.example.demo.videoclub.model;

import javax.persistence.*;

import com.example.demo.videoclub.model.views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@Column(name = "numero")
	@JsonView(JsonViews.Common.class)
	private Integer numero;
	@Column(name = "rue", length = 150)
	@JsonView(JsonViews.Common.class)
	private String rue;
	@Column(name = "ville", length = 50)
	@JsonView(JsonViews.Common.class)
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
