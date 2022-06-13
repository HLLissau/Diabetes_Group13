package group13.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Measurement;



@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {

	List<Measurement> findAllByUserId(Long patientId);
	
	@Query(value = "SELECT *  FROM measurement "
		     + "WHERE user_id= ?1 "  
		     + "And time BETWEEN ?2 AND ?3 ",
		nativeQuery=true)
	List<Measurement> findByUserIdByTimeBetween(Long userId,String startDate, String endDate);
	
	@Query(value = "SELECT time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + "  FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY UNIX_TIMESTAMP(time) DIV 3600",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByHourByTimeBetween(Long userId,String startDate, String endDate);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Day(Time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByDayByTimeBetween(Long userId,String startDate, String endDate);

	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Week(Time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByWeekbyTimeBetween(Long userId, String startDate, String endDate);

	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Month(Time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByMonthbyTimeBetween(Long userId, String startDate, String endDate);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Year(Time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByYearbyTimeBetween(Long userId, String startDate, String endDate);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByallTimebyTimeBetween(Long userId, String startDate, String endDate);
}










