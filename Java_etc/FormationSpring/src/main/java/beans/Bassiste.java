package beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bassiste implements MusicienACordes{

	@Resource(name="basse")
	private ACordes basse;
	@Autowired
	public Bassiste() {
		
	}

	public ACordes getBasse() {
		return basse;
	}

	public void setBasse(ACordes basse) {
		this.basse = basse;
	}

	@Override
	public void jouer() {

		System.out.println("Je suis un bassiste");
		basse.joue();
		
	}

}
