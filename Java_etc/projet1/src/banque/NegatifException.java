package banque;

public class NegatifException extends Exception{
	
	public NegatifException() {
		super("On ne peut pas cr�diter d'une somme n�gative !");
	}
	
}
