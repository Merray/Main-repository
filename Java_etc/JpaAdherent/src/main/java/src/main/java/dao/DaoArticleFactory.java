package src.main.java.dao;

public class DaoArticleFactory {

	private static DaoArticle daoArticle = null;
	
	private DaoArticleFactory() {
		
	}
	
	public static DaoArticle getInstance() {
		
		if (daoArticle == null) {
			
			daoArticle = new DaoArticleJpaImpl();
		}
		return daoArticle;
		
	}

}
