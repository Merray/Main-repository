package convertisseur;

import java.util.regex.Pattern;

public class ConvertisseurImpl implements Convertisseur {

	private static final String CHIFFRESROMAINS[][] = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM", "", "", "", "", "", "" } };

	private static final String ROMAINVALID = "IVXLCDM";
	private static final int[] ROMAINVALUE = { 1, 5, 10, 50, 100, 500, 1000 };

	@Override
	public String convertArabToRomain(int arab) {
		String romain = "";
		if (arab < 1)
			throw new IllegalArgumentException("nombre inferieur à 1,traduction impossible");
		if (arab > 3999)
			throw new IllegalArgumentException("nombre superieur à 3999,traduction impossible");
		for (int i = 3; i >= 0; i--) {
			romain += CHIFFRESROMAINS[i][(int) (arab / Math.pow(10, i))];
			arab = (int) (arab % Math.pow(10, i));
		}
		return romain;
	}

	@Override
	public int convertRomainToArab(String romain) {
		int arab = 0;
		int previous = 0;
		int current = 0;

		Pattern pattern = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		if (!pattern.matcher(romain).matches()) {
			throw new IllegalArgumentException("nombre romain mal ecrit");
		}
		for (int i = 0; i < romain.length(); i++) {
			current = convertRomainCharToArab(romain.charAt(i));
			arab = arab + current;
			if (previous != 0 && previous < current) {
				arab = arab - 2 * previous;
			}
			previous = current;
		}
		return arab;
	}

	private int convertRomainCharToArab(char c) {
		int index = ROMAINVALID.indexOf(c);
		if (index == -1) {
			throw new IllegalArgumentException("caractere romain incorrect");
		}
		return ROMAINVALUE[index];
	}

}
