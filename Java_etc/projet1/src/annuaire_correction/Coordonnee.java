package annuaire_correction;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Coordonnee implements Serializable {

	private String type;
	private String telephone;
	private String adresse;

	/**
	 * @param type
	 * @param telephone
	 * @param adresse
	 * @throws TelephoneException
	 */
	public Coordonnee(String type, String telephone, String adresse) throws TelephoneException {
		if (!Pattern.matches("^(\\+33|0)\\d((\\s|-)?\\d{2}){4}$", telephone)) {
			throw new TelephoneException();
		}
		this.type = type;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnee other = (Coordonnee) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordonnee [type=" + type + ", telephone=" + telephone + ", adresse=" + adresse + "]";
	}
}
