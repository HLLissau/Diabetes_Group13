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
	
	@Query(value = "SELECT *  FROM measurement "
		     + "WHERE user_id= ?1 "  
		     + "And time BETWEEN ?2 AND ?3 ",
		nativeQuery=true)
	List<Measurement> findAllByUserIdByTimeBetween(Long UserId,String startDate, String endDate);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + "  FROM measurement "
		     + "WHERE user_id= ?1 "
		     + "And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Day(Time)",
		nativeQuery=true)
	List<Measurement> findAllAvgByUserIdByTimeBetween(Long UserId,String startDate, String endDate);

	
	
	List<Measurement> findAllByTime(Timestamp time);

	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
			     + "  FROM measurement "
			     + "WHERE user_id= ?1 "  
			     + " GROUP BY Day(Time)",
			nativeQuery=true)

	List<Measurement> findAvgByDayForUserId(Long user_Id);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + "  FROM measurement "
		     + "WHERE user_id= ?1 "  
		     + " GROUP BY Week(Time) ",
		nativeQuery=true)
	List<Measurement> findAvgByWeekForUserId(Long user_Id);

	
	
}










