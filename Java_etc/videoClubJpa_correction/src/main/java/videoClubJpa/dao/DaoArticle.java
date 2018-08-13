package videoClubJpa.dao;

import java.util.List;

import videoClubJpa.model.Article;
import videoClubJpa.model.BluRay;
import videoClubJpa.model.Dvd;

public interface DaoArticle extends DaoGeneric<Article, Integer> {

	public List<Dvd> findAllDvd();

	public List<BluRay> findAllBluRay();
}
