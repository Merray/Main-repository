package mainApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import beans.Musicien;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Musicien guitariste = (Musicien) ctx.getBean("guitariste");
		Musicien bassiste = (Musicien) ctx.getBean("bassiste");
		Musicien saxophoniste = (Musicien) ctx.getBean("saxophoniste");

		
		guitariste.jouer();
		bassiste.jouer();
		saxophoniste.jouer();

		ctx.close();
	}

}
