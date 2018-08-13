package dao;

import java.util.List;

import model.Adherent;
import model.Article;

public interface DaoAdherent extends DaoGeneric<Adherent, Integer> {
	public List<Article> findArticleByAdherent(Adherent adherent);
}
