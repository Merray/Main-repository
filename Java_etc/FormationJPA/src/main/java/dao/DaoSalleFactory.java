package dao;

public class DaoSalleFactory {
	private static DaoSalle daoSalle = null;

	private DaoSalleFactory() {

	}

	public static DaoSalle getInstance() {
		if (daoSalle == null) {
			daoSalle = new DaoSalleJpaImpl();
		}
		return daoSalle;
	}
}
