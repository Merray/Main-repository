package annuaire;


import java.io.Serializable;
import java.util.regex.Pattern;

public class Coordonnees implements Serializable{
	private String tel;
	private String adresse;
	
	private String monPattern = "^([(\\+33)(0)])*([1-9]\\s)*(\\d{2}\\s){3}\\d{2}";
	
	
	public Coordonnees(String tel, String adresse) {
		
		
		
		if (Pattern.matches(monPattern, tel)) {
			this.tel = tel;
		}
		else {this.tel = null;}
		
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "[tel=" + tel + ", adresse=" + adresse + "]";
	}
	
	
	
}
