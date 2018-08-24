package com.example.demo.videoclub.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B")
public class Blueray extends Article {
	@Column(name = "troisd")
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
