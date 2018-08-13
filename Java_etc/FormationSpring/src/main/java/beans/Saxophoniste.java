package beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Saxophoniste implements Musicien{

	@Resource(name="saxophone")
	private AVent instrument;
	@Autowired
	public Saxophoniste() {
		
	}

	public AVent getGuitare() {
		return instrument;
	}

	public void setGuitare(AVent saxophone) {
		this.instrument = saxophone;
	}

	@Override
	public void jouer() {

		System.out.println("Je suis un saxophoniste");
		instrument.joue();
		
	}


}
