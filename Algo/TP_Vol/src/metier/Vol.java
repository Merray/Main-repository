package metier;
import java.util.Date;

public class Vol {

	private String num, villeDepart, villeArrivee;
	private Date dateDepart, dateArrivee;
	private boolean resaEtat;

	public Vol(String num, String villeDepart, String villeArrivee, Date dateDepart, Date dateArrivee,
			boolean resaEtat) {
		this.num = num;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.resaEtat = resaEtat;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public boolean isResaEtat() {
		return resaEtat;
	}

	public void setResaEtat(boolean resaEtat) {
		this.resaEtat = resaEtat;
	}

	public String toString() {
		return "Vol [num=" + num + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", dateDepart="
				+ dateDepart + ", dateArrivee=" + dateArrivee + ", resaEtat=" + resaEtat + "]";
	}
	
	
}
