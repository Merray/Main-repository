package videoClubJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	private static EntityManagerFactory emf = null;

	private Singleton() {

	}

	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("videoClubJpa");
		}
		return emf;
	}

	public static void destroy() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
