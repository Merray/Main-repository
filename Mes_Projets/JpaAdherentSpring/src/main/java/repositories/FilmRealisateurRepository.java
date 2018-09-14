package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.FilmRealisateur;
import model.FilmRealisateurPk;

public interface FilmRealisateurRepository extends JpaRepository<FilmRealisateur, FilmRealisateurPk>{

}
