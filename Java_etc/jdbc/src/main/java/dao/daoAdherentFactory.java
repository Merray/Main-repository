package dao;

public class daoAdherentFactory {

	private daoAdherentFactory() {
		
	}
	
	
	public static DaoAdherent getInstance() {
		return new DaoAdherentJdbcImpl();
	}
}
