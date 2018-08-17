package videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videoclub.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}
