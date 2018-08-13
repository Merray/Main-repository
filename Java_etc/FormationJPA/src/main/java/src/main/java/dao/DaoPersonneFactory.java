package src.main.java.dao;

public class DaoPersonneFactory {

	private static DaoPersonne daoPersonne = null;
	
	private DaoPersonneFactory() {
		
	}
	
	public static DaoPersonne getInstance() {
		
		if (daoPersonne == null) {
			
			daoPersonne = new DaoPersonneJpaImpl();
		}
		return daoPersonne;
		
	}

}
