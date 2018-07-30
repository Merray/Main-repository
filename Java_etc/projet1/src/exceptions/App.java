package exceptions;

public class App {

	public static void main(String[] args) {

		try {
			Naturel unNaturel = new Naturel(-10);
		} catch (NegatifException e) {
			e.printStackTrace();
		}


		System.out.println("Après le try/catch");
	}

}
