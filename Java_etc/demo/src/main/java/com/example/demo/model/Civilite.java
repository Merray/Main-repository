package com.example.demo.model;

public enum Civilite {
	MONSIEUR("Mr"), MADAME("Mme"), MADEMOISELLE("Mlle");
	
	private String civilite;
	
	private Civilite(String civilite) {
		this.civilite = civilite;
	}
	
	public String getCivilite() {
		return civilite;
	}
}
