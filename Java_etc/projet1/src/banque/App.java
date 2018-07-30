package banque;

public class App {

	public static void main(String[] args) {
		
		CompteSimple c1 = new CompteSimple("Jimmy", 06055, 500);
		CompteSimple c12 = new CompteSimple("Jimmy2", 060556, 500);
		CompteVIP c2 = new CompteVIP("JimmyVIP", 0060551, 750);
		CompteCB c3 = new CompteCB("JimmyCB", 060552, 50, CB.VISA);
		
		try {
			System.out.println("Débiter: " +c1.debiter(0));
		} catch (DecouvertException | NegatifException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.getSolde());
		
		try {
			System.out.println( "Créditer: " +c1.crediter(0));
		} catch (NegatifException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.getSolde());
		
		try {
			System.out.println( "Virement: " +c1.virement(50, c12));
		} catch (NegatifException | DecouvertException e) {
			e.printStackTrace();
		}
		
		System.out.println(c1.getSolde());
		System.out.println(c12.getSolde());
		
	}
}
