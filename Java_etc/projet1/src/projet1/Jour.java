package projet1;

public enum Jour {
	LUNDI("Lundi", "Monday"), MARDI("Mardi","Tuesday"), MERCREDI("Mercredi", "Wednesday"), JEUDI("Jeudi","Thursday"), VENDREDI("Vendredi","Friday"), SAMEDI("Samedi","Saturday"), DIMANCHE("Dimanche","Sunday");
	
	private String français;
	private String anglais;
	
	private Jour(String français, String anglais) {
		this.français = français;
		this.anglais = anglais;
	}
	
	
	public String getFr() {
		return français;
	}
	public String getEn() {
		return anglais;
	}
	
	
}
