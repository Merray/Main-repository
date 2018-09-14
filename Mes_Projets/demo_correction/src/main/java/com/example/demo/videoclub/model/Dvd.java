package com.example.demo.videoclub.model;

import javax.persistence.*;

import com.example.demo.videoclub.model.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("dvd")
public class Dvd extends Article {
	@Column(name = "bonus")
	@JsonView(JsonViews.Common.class)

	private Boolean bonus;

	public Dvd() {
		super();
	}
	
	public Boolean getBonus() {
		return bonus;
	}
	
	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}

}
