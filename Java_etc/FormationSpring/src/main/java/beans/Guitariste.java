package beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements MusicienACordes {

	@Resource(name = "guitare")
	private ACordes guitare;
	@Resource(name = "basse")
	private ACordes basse;

	@Autowired
	public Guitariste() {

	}

	public ACordes getGuitare() {
		return guitare;
	}

	public void setGuitare(ACordes guitare) {
		this.guitare = guitare;
	}

	public ACordes getBasse() {
		return basse;
	}

	public void setBasse(ACordes basse) {
		this.basse = basse;
	}

	@Override
	public void jouer() {

		
		System.out.println("Je suis un guitariste");
		guitare.joue();
		basse.joue();
		

	}

}
