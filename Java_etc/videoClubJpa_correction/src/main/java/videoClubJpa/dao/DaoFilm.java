package videoClubJpa.dao;

import java.util.List;

import videoClubJpa.model.Film;

public interface DaoFilm extends DaoGeneric<Film, Integer> {
	public List<Film> findAllWithArticle();

	public Film findByKeyWithArticles(Integer key);
}
