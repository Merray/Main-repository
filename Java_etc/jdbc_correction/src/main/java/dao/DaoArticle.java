package dao;

import java.util.List;

import model.Article;
import model.BluRay;

public interface DaoArticle extends DaoGeneric<Article, Integer> {
	public List<BluRay> findAllBluRay();
}
