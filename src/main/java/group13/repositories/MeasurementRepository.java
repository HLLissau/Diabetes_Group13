package group13.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Measurement;



@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
	//List<Measurement> findAll();
	
	@Query("Select time,measurement from Measurement WHERE userId= ?1")
	List<Measurement> findAllByUserID(Long patientId);
	
}









