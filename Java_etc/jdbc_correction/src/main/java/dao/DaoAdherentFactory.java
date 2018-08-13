package dao;

public class DaoAdherentFactory {

	private DaoAdherentFactory() {

	}

	public static DaoAdherent getInstance() {
		return new DaoAdherentJdbcImpl();
	}
}
