package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Integer>{

	
	List<Adherent> findCustomByCity(@Param("ville") String ville);
	
}
