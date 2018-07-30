package banque;

public class DecouvertException extends Exception{
	
	public DecouvertException() {
		super("Cette banque ne permet pas d'être à découvert !");
	}
	
}
