package src.main.java.dao;

public class DaoAdherentFactory {

	private static DaoAdherent daoAdherent = null;
	
	private DaoAdherentFactory() {
		
	}
	
	public static DaoAdherent getInstance() {
		
		if (daoAdherent == null) {
			
			daoAdherent = new DaoAdherentJpaImpl();
		}
		return daoAdherent;
		
	}

}
