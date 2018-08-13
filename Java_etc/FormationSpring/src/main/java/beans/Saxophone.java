package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("saxophone")
public class Saxophone implements AVent{

	public Saxophone() {

	}

	public void joue() {
		System.out.println("Je joue du saxophone!");
	}
}
