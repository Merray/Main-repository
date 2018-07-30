package projet1;

public enum Jour {
	LUNDI("Lundi", "Monday"), MARDI("Mardi","Tuesday"), MERCREDI("Mercredi", "Wednesday"), JEUDI("Jeudi","Thursday"), VENDREDI("Vendredi","Friday"), SAMEDI("Samedi","Saturday"), DIMANCHE("Dimanche","Sunday");
	
	private String fran�ais;
	private String anglais;
	
	private Jour(String fran�ais, String anglais) {
		this.fran�ais = fran�ais;
		this.anglais = anglais;
	}
	
	
	public String getFr() {
		return fran�ais;
	}
	public String getEn() {
		return anglais;
	}
	
	
}
