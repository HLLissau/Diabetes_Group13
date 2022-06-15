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
		     + " GROUP BY Year(time), Month(time), Day(time), Hour(time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByHourByTimeBetween(Long userId,String startDate, String endDate);
	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Year(time), Month(time), Day(time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByDayByTimeBetween(Long userId,String startDate, String endDate);

	
	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Year(Time), Week(Time)",
		nativeQuery=true)
	List<Measurement> findAvgByUserIdByWeekbyTimeBetween(Long userId, String startDate, String endDate);

	@Query(value = "SELECT DATE(time) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
		     + " FROM measurement"
		     + " WHERE user_id= ?1"
		     + " And time BETWEEN ?2 AND ?3"
		     + " GROUP BY Year(Time), Month(Time)",
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
	
	
	@Query(value = "(select bolus,time from measurement where user_id = ?1"
			+ "   AND time = (select max(time) as time from measurement"
			+ " where user_id =?1 AND Bolus!=0))"
            ,nativeQuery=true)
    Object findLatestBolus(Long userId);
	
	@Query(value = "(select basal,time from measurement where user_id = ?1"
			+ "   AND time = (select max(time) as time from measurement"
			+ " where user_id =?1 AND basal!=0))"
            ,nativeQuery=true)
    Object findLatestBasal(Long userId);
	
	@Query(value = "(select measurement,time from measurement where user_id = ?1"
			+ "   AND time = (select max(time) as time from measurement"
			+ " where user_id =?1 AND measurement!=0))"
            ,nativeQuery=true)
    Object findLatestMeasurement(Long userId);
	
	@Query(value = "(select meals,time from measurement where user_id = ?1"
			+ "   AND time = (select max(time) as time from measurement"
			+ " where user_id =?1 AND meals!=0))"
            ,nativeQuery=true)
    Object findLatestMeals(Long userId);
	
	@Query(value = "(select exercise,time from measurement where user_id = ?1"
			+ "   AND time = (select max(time) as time from measurement"
			+ " where user_id =?1 AND exercise!=0))"
            ,nativeQuery=true)
    Object findLatestExercise(Long userId);
	
	
	
}










