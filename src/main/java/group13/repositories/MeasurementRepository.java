package group13.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Measurement;



@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
	
	
	List<Measurement> findAll();
	

	@Query(value = "Select * from Measurement WHERE user_id= ?1",
			nativeQuery = true)
	List<Measurement> findAllByUserID(Long patientId);
	
}









