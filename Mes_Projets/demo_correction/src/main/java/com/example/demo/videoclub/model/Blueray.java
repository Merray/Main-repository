package com.example.demo.videoclub.model;

import javax.persistence.*;

import com.example.demo.videoclub.model.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("blueray")
public class Blueray extends Article {
	@Column(name = "troisd")
	@JsonView(JsonViews.Common.class)
	private Boolean troisD;

	public Blueray() {
	}

	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}

}
