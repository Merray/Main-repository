package beans;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Spectateur {

	@Pointcut("execution(* *.jouer(..))")
	
	@Before("jouer()")
	public void prendPlace() {
		System.out.println("Les spectateurs prennent place");
	}
	
	@Before("jouer()")
	public void eteindreTelephone() {
		System.out.println("Les spectateurs éteignent leur telephone");
	}
	
	@AfterReturning("jouer()")
	public void applaudir() {
		System.out.println("Bravooo!");
	}
	@AfterThrowing("jouer()")
	public void demanderRemboursement() {
		System.out.println("Les spectateurs jetent des tomates et veulent être remboursés! BOOUUUUUH!");
	}
	
	public Spectateur() {
	}

}
