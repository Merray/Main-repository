package exception_correction;

public class App {

	public static void main(String[] args) {
		A a = new A();
		a.i=10;
		System.out.println(a.i);
	}

}

class A {
	public Integer i;
}
