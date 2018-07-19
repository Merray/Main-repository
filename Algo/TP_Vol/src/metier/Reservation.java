package metier;



public class Reservation {

	private String num, dateResa;
	private boolean paiement;


	public Reservation(String num, String dateResa, boolean paiement) {
		this.num = num;
		this.dateResa = dateResa;
		this.paiement = paiement;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public boolean isPaiement() {
		return paiement;
	}

	public void setPaiement(boolean paiement) {
		this.paiement = paiement;
	}

	public String getDateResa() {
		return dateResa;
	}

	public void setDateResa(String dateResa) {
		this.dateResa = dateResa;
	}

	@Override
	public String toString() {
		return "Reservation [num=" + num + ", paiement=" + paiement + ", dateResa=" + dateResa + "]";
	}


}
