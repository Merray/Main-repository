package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Salle;

public interface SalleRepository extends JpaRepository<Salle, Integer>{

	@Query("select s from Salle s left join fetch s.personnes where s.numero= :numeroSalle")
	Optional<Salle> findCustomByIdWithPersonnes(@Param("numeroSalle") Integer numero);
	
	List<Salle> findAllCustomWithPersonnes();
}
