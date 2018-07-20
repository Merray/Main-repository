import java.util.Scanner;

public class Calculette {

	public static double add(double nb1, double nb2) {

		double result = nb1 + nb2;
		return result;

	}

	public static double soustract(double nb1, double nb2) {

		double result = nb1 - nb2;
		return result;

	}

	public static double multip(double nb1, double nb2) {

		double result = nb1 * nb2;
		return result;

	}

	public static double divis(double nb1, double nb2) {

		double result = nb1 / nb2;
		return result;


	}


	public static void main(String[] args) {

		double nb1, nb2, result;
		String operateur;

		Scanner scDouble = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);


		System.out.println("Premier nombre ?");
		nb1 = scDouble.nextDouble();

		System.out.println("Opérateur ?");
		operateur = scString.nextLine();

		System.out.println("Deuxième nombre ?");
		nb2 = scDouble.nextDouble();


		switch(operateur) {

		case "+" : result = add(nb1,nb2);break; 
		case "-" : result = soustract(nb1,nb2);break;
		case "*" : result = multip(nb1,nb2);break;
		case "/" : result = divis(nb1,nb2);break;
		default : result = add(nb1,nb2);break;


		}

		System.out.println("Le résultat de "+nb1+" "+operateur+ " "+ nb2+ " vaut "+ result + " !" );
		scDouble.close();
		scString.close();
	}

}
