package com.example.demo.videoclub.model;

public enum Civilite {
	M("monsieur"), MME("madame");
	
	private String titre;
	
	private Civilite(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
