package jdbc;

import dao.DaoAdherent;
import dao.daoAdherentFactory;
import jdbc.model.Adherent;
import jdbc.util.Context;

public class App {

	public static void main(String[] args) throws Exception {
		
		
		DaoAdherent daoAdherent = daoAdherentFactory.getInstance();
		
		//Adherent tibo = new Adherent(7, "Tibo","Inshape");
		
		//daoAdherent.insert(tibo);
		
		//daoAdherent.delete(tibo);
		
		daoAdherent.deleteByKey(7);
		
		System.out.println(daoAdherent.findAll());
		
		
		
		
		// A faire en dernier
		Context.destroy();
	}

}
