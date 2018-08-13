package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("basse")
public class Basse implements ACordes{

	public Basse() {

	}

	public void joue() {
		System.out.println("Je joue de la basse !");
	}
}
