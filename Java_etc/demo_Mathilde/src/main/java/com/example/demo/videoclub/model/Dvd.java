package com.example.demo.videoclub.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("D")
public class Dvd extends Article {
	@Column(name = "bonus")
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
