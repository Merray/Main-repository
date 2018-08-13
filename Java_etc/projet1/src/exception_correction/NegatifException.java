package exception_correction;

public class NegatifException extends Exception {
	public NegatifException() {
		super("nombre negatif interdit");
	}
}
