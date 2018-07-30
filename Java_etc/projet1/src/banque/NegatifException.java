package banque;

public class NegatifException extends Exception{
	
	public NegatifException() {
		super("On ne peut pas créditer d'une somme négative !");
	}
	
}
