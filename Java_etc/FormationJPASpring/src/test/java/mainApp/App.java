package mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repositories.PersonneRepository;
import repositories.SalleRepository;

public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonneRepository personneRepository = ctx.getBean(PersonneRepository.class);
		
//		System.out.println(personneRepository.findByPrenomContaining("i"));
		System.out.println(personneRepository.findByPrenomEndingWith("y"));
		
		SalleRepository salleRepository = ctx.getBean(SalleRepository.class);
		
		System.out.println(salleRepository.findAllCustomWithPersonnes());
		
		
	}

}
