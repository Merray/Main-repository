package convertisseur;

public class MonConvertisseur implements Convertisseur {

	@Override
	public String convertArabToRomain(int arab) {

		if (arab <= 0) {
			throw new IllegalArgumentException();
		} else if (arab >3999) {
			throw new IllegalArgumentException();
		}else {
			String retour = "";

			switch (arab) {

			case 1:
				retour += "I";
				break;

			case 5:
				retour += "V";
				break;

			case 10:
				retour += "X";
				break;

			case 50:
				retour += "L";
				break;

			case 100:
				retour += "C";
				break;

			case 500:
				retour += "D";
				break;

			case 1000:
				retour += "M";
				break;

			default:
				break;
			}

			if (arab != 1 && arab != 5 && arab != 10 && arab != 50 && arab != 100 && arab != 500 && arab != 1000) {

				if (arab >= 3000) {
					retour += "MMM";
					arab -= 3000;
				} else if (arab >= 2000) {
					retour += "MM";
					arab -= 2000;
				} else if (arab >= 1000) {
					retour += "M";
					arab -= 1000;
				}

				if (arab >= 900) {
					retour += "CM";
					arab -= 900;
				} else if (arab >= 800) {
					retour += "DCCC";
					arab -= 800;
				} else if (arab >= 700) {
					retour += "DCC";
					arab -= 700;
				} else if (arab >= 600) {
					retour += "DC";
					arab -= 600;
				} else if (arab >= 500) {
					retour += "D";
					arab -= 500;
				} else if (arab >= 400) {
					retour += "CD";
					arab -= 400;
				} else if (arab >= 300) {
					retour += "CCC";
					arab -= 300;
				} else if (arab >= 200) {
					retour += "CC";
					arab -= 200;
				} else if (arab >= 100) {
					retour += "C";
					arab -= 100;
				}

				if (arab >= 90) {
					retour += "XC";
					arab -= 90;
				} else if (arab >= 80) {
					retour += "LXXX";
					arab -= 80;
				} else if (arab >= 70) {
					retour += "LXX";
					arab -= 70;
				} else if (arab >= 60) {
					retour += "LX";
					arab -= 60;
				} else if (arab >= 50) {
					retour += "L";
					arab -= 50;
				} else if (arab >= 40) {
					retour += "XL";
					arab -= 40;
				} else if (arab >= 30) {
					retour += "XXX";
					arab -= 30;
				} else if (arab >= 20) {
					retour += "XX";
					arab -= 30;
				} else if (arab >= 10) {
					retour += "X";
					arab -= 30;
				}

				switch (arab) {
				case 9:
					retour += "IX";
					break;
				case 8:
					retour += "VIII";
					break;
				case 7:
					retour += "VII";
					break;
				case 6:
					retour += "VI";
					break;
				case 5:
					retour += "V";
					break;
				case 4:
					retour += "IV";
					break;
				case 3:
					retour += "III";
					break;
				case 2:
					retour += "II";
					break;
				case 1:
					retour += "I";
					break;
				default:
					break;
				}

			}
			return retour;
		}

	}

	@Override
	public int convertRomainToArab(String romain) {

		String fullPattern = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		
		return 0;
	}

}
