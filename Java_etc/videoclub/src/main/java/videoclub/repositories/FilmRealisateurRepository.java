package videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videoclub.model.FilmRealisateur;
import videoclub.model.FilmRealisateurPK;

public interface FilmRealisateurRepository extends JpaRepository<FilmRealisateur, FilmRealisateurPK> {

}
