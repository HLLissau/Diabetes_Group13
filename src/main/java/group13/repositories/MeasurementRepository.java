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
	
	

	@Query(value ="Select concat(subdate(date(?2),1),concat(\" \" , time(time))) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
			+ " from measurement "
			+ "	where user_id=?1"
			+ "	AND time(time) > time(?2)"
			+ "	group by time(time) "
			+ "	Union"
			+ "	Select concat(date(?2),concat(\" \" , time(time))) as time,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement "
			+ " from measurement"
			+ " where user_id=?1"
			+ " AND time(time) < time(?2)"
			+ " group by time(time)"
			
			,nativeQuery=true)
	List<Measurement> findAvgByUserIdForDay(Long userId, String endDate);
	
	
	@Query(value =
			"call getAvgByWeek(?1,?2)"
			
					,nativeQuery=true)
	List<Measurement> findAvgByUserIdForWeek(Long userId, String endDate);
	
	
	
	
	@Query(value =//"call getAvgByMonth(?1,?2)"
			  " select  CASE "
			+ "			WHEN  time > ?2 "
			+ "	        THEN inner1.time  - INTERVAL 1 Month"
			+ "	        ELSE inner1.time"
			+ "		END  as time,"
			+ "		inner1.user_id,inner1.basal,inner1.bolus,inner1.device_id,inner1.exercise,inner1.meals,inner1.measurement from ("
			+ "			SELECT subdate(time,("
			+ "				 SELECT datediff(time, ?2 ) from measurement"
			+ "				 WHERE user_id= ?1 "
			+ "				 AND day(time)=day( ?2 )"
			+ "				 GROUP BY day(time)"
			+ "	        )) as time "
			+ "			,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement "
			+ "			FROM measurement"
			+ "			WHERE user_id= ?1 "
			+ "			GROUP BY day(time) "
			+ "			) inner1"
			+ "		ORDER BY time"
			,nativeQuery=true)
	
	List<Measurement> findAvgByUserIdForMonth(Long userId,String Date);

	@Query(value = //"call getAvgByYear(?1,?2)"
			  " select  CASE"
			+ "			WHEN  time > ?2"
			+ "	        THEN (inner1.time  - INTERVAL 1 Year - interval weekday( ?2 ) day)"
			+ "	        ELSE (inner1.time- INTERVAL weekday( ?2 ) day)"
			+ "		END  as time,"
			+ "		inner1.user_id,inner1.basal,inner1.bolus,inner1.device_id,inner1.exercise,inner1.meals,inner1.measurement from ("
			+ "			select time - INTERVAL"
			+ "				 (select datediff(time,?2) from measurement"
			+ "				 where user_id=?1"
			+ "	             AND Month(time)= MONTH(?2)"
			+ "				 And WEEK(time)=WEEK(?2)"
			+ "				 group by WEEK(time) "
			+ "	        ) DAY  as time "
			+ "	,user_id,avg(basal) as basal,avg(bolus) as bolus,device_id,avg(exercise) exercise,avg(meals) as meals,avg(measurement) as measurement"
			+ " from measurement"
			+ "	where user_id=?1"
			+ "			group by WEEK(time) "
			+ "			) inner1"
			+  "	order By time "
	   	
			,nativeQuery=true)
	List<Measurement> findAvgByUserIdForYear(Long userId, String endDate);


	@Query(value ="call getAvgByAllTime(?1,?2)"
			,nativeQuery=true)
	List<Measurement> findAvgByUserIdForAllTime(Long userId, String endDate);

	
	// get latest measurements for user. 
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

    @Query(value = "select 100*(count(measurement>13.88)/COUNT(measurement)) as VeryHigh,"
    		+ " 100*(count(10<measurement and measurement<13.88)/COUNT(measurement)) as High,"
    		+ " 100*(count(3.88<measurement and measurement<10)/COUNT(measurement)) as Target,"
    		+ " 100*(count(3<measurement and measurement<3.88)/COUNT(measurement)) as Low,"
    		+ " 100*(count(measurement<3)/COUNT(measurement)) as VeryLow "
    		+ " from measurement where user_Id= ?1 "
    		+ " And time BETWEEN ?2 -interval 1 day AND ?2 "
	, nativeQuery=true)
	Object getPercentageQuery(Long userId, String date);
}










