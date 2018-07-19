package metier;

public class Adresse{
	private int num;
	private String rue, cp, ville;

	public Adresse(int num, String rue, String cp, String ville) {
		this.num = num;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [num=" + num + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}
	
	
}
