package videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videoclub.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
