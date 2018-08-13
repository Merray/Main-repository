package exception_correction;

public class Naturel {
	private int n;

	/**
	 * @param n
	 * @throws NegatifException 
	 */
	public Naturel(int n) throws NegatifException {
		if (n < 0) {
			throw new NegatifException();
		}
		this.n = n;

	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
