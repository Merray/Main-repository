package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("guitare")
public class Guitare implements ACordes{

	public Guitare() {

	}

	public void joue() {
		System.out.println("Je joue de la guitare !");
	}
}
