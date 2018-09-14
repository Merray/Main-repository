package mesTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import convertisseur.Convertisseur;
import convertisseur.MonConvertisseur;

public class TestConvertisseur {

	private static Convertisseur convertisseur = new MonConvertisseur();

	
	private void doArabToRomain(int arab, String romain) {
		assertEquals(romain, convertisseur.convertArabToRomain(arab));
	}

	private void doRomainToArab(String romain, int arab) {
		assertEquals(arab, convertisseur.convertRomainToArab(romain));
	}

	@Test
	public void traduction1() {
		doArabToRomain(1, "I");
	}

	@Test
	public void traductionI() {
		doRomainToArab("I", 1);
	}

	@Test
	public void traduction5() {
		doArabToRomain(5, "V");
	}

	@Test
	public void traductionV() {
		doRomainToArab("V", 5);
	}

	@Test
	public void traduction10() {
		doArabToRomain(10, "X");
	}

	@Test
	public void traductionX() {
		doRomainToArab("X", 10);
	}

	@Test
	public void traductionArabToRomain() {
		int[] arabs = { 1, 5, 10, 50, 100, 500, 1000, 152, 2676 };
		String[] romains = { "I", "V", "X", "L", "C", "D", "M", "CLII", "MMDCLXXVI" };
		for (int i = 0; i < arabs.length; i++) {
			doArabToRomain(arabs[i], romains[i]);
		}
	}

	@Test
	public void traductionRomainToArab() {
		int[] arabs = { 1, 4, 10, 50, 90, 500, 1000, 152, 2676 };
		String[] romains = { "I", "IV", "X", "L", "XC", "D", "M", "CLII", "MMDCLXXVI" };
		for (int i = 0; i < romains.length; i++) {
			doRomainToArab(romains[i], arabs[i]);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreArabInferieurAOuEgal0() {
		doArabToRomain(0, null);
	}

	@Test
	public void traductionArabToArab() {
		for (int i = 1; i <= 3999; i++) {
			assertEquals(i, convertisseur.convertRomainToArab(convertisseur.convertArabToRomain(i)));
		}
	}

	// Si chiffre arabe superieur à 3999 exception ??? avec message d'erreur
	// nombre superieur à 3999
	@Test(expected = IllegalArgumentException.class)
	public void nombreArabSuperierA3999() {
		doArabToRomain(5000, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreRomainAvecCaractereInvalide() {
		doRomainToArab("P", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nombreRomainMalEcris() {
		doRomainToArab("CDM", 0);
	}

}
