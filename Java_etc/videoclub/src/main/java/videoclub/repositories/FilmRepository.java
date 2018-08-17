package videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videoclub.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
