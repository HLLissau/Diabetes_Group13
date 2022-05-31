package group13.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Measurement;



@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
	
	
	List<Measurement> findAll();
	
// The following used to be a native que
//	@Query(value = "Select * from Measurement WHERE user_id= ?1",
//			nativeQuery = true)
	List<Measurement> findAllByUserId(Long patientId);
	
	List<Measurement> findAllByTime(Timestamp time);

	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
			     + "  FROM measurement "
			     + "WHERE user_id= ?1 "  
			     + " GROUP BY Day(Time) ",
			nativeQuery=true)
//	@Query("SELECT e.time,e.userId,avg(e.basal) as basal,avg(e.bolus) as bolus,device_Id,avg(e.measurement) as measurement,avg(e.exercise) as exercise, avg(e.meals) as meals"
//			+ " FROM Measurement e "
//			+ " WHERE e.userId = ?1"
//			+ " GROUP BY DATE(e.time)")
	List<Measurement> findAvgByDayForUserId(Long user_Id);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + "  FROM measurement "
		     + "WHERE user_id= ?1 "  
		     + " GROUP BY Week(Time) ",
		nativeQuery=true)
	List<Measurement> findAvgByWeekForUserId(Long user_Id);
	
	
	
}










