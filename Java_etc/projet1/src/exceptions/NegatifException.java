package exceptions;

public class NegatifException extends Exception{
	
	public NegatifException() {
		super("Nombre négatif interdit");
	}
	
}
