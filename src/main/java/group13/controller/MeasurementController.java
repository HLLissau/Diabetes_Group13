package group13.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import group13.model.Measurement;
import group13.repositories.MeasurementRepository;

@Controller
@CrossOrigin
public class MeasurementController {

	@Autowired
	private MeasurementRepository MeasurementRepository;
	
	
	// Getting all measurements for a user
	@GetMapping("/api/v1/patient/{userId}/getData")
	public ResponseEntity<List<Measurement>> getall(@PathVariable Long userId) {
		List<Measurement> result = MeasurementRepository.findAllByUserId(userId);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
	}

	// Get all measurements for a user within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> getData(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findByUserIdByTimeBetween(userId, startDate, endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
	}
//	

	/********************
	 * GETTING AVERAGES *
	 ********************/

	// Average measurements for a user over each hour within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byHour/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByHour(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByHourByTimeBetween(userId, startDate, endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}

	// Average measurements for a user over each day within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byDay/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByDay(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByDayByTimeBetween(userId, startDate, endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}

	// Average measurements for a user over each week within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byWeek/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByWeek(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByWeekbyTimeBetween(userId, startDate, endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}

	// Average measurements for a user over each month within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byMonth/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByMonth(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByMonthbyTimeBetween(userId, startDate,
				endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}


	// Average measurements for a user over each month within a time interval

	@GetMapping("/api/v1/patient/{userId}/getData/average/byYear/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByYear(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByYearbyTimeBetween(userId, startDate, endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}

	// Average measurements for a user over each month within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/allTime/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByAllTime(@PathVariable long userId, @PathVariable String startDate,
			@PathVariable String endDate) {
		List<Measurement> result = MeasurementRepository.findAvgByUserIdByallTimebyTimeBetween(userId, startDate,
				endDate);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(result);
	}
	

	/********************
	 * GETTING RECENTS *
	 ********************/

		// Most recent bolus measurement and its time
	@GetMapping("/api/v1/patient/{userId}/getData/recent/bolus")
	public ResponseEntity<Object> recentBolus(@PathVariable long userId) {
		Object result = MeasurementRepository.findLatestBolus(userId);
		return ResponseEntity.ok(result);
	}

	// Most recent basal measurement and its time
	@GetMapping("/api/v1/patient/{userId}/getData/recent/basal")
	public ResponseEntity<Object> recentBasal(@PathVariable long userId) {
		Object result = MeasurementRepository.findLatestBasal(userId);
		return ResponseEntity.ok(result);
	}

	// Most recent measurement measurement and its time
	@GetMapping("/api/v1/patient/{userId}/getData/recent/measurement")
	public ResponseEntity<Object> recentMeasurement(@PathVariable long userId) {
		Object result = MeasurementRepository.findLatestMeasurement(userId);
		return ResponseEntity.ok(result);
	}
	// Most recent meals measurement and its time
		@GetMapping("/api/v1/patient/{userId}/getData/recent/meals")
		public ResponseEntity<Object> recentMeals(@PathVariable long userId) {
			Object result = MeasurementRepository.findLatestMeals(userId);
			return ResponseEntity.ok(result);
		}
		
		// Most recent exercise measurement and its time
		@GetMapping("/api/v1/patient/{userId}/getData/recent/exercise")
		public ResponseEntity<Object> recentExercise(@PathVariable long userId) {
			Object result = MeasurementRepository.findLatestExercise(userId);
			return ResponseEntity.ok(result);
		}
		
	/* 
	 * The following Api's are used to generate averages used in statspage
	 */
	
	// Average measurements for a user grouped by time, over last 24 hours from time
		@GetMapping("/api/v1/patient/{userId}/getData/average/ForDay/{time}")
					  
		public ResponseEntity<List<Measurement>> findAvgByUserIdForDay(@PathVariable long userId, @PathVariable String time) {
			List<Measurement> result =MeasurementRepository.findAvgByUserIdForDay(userId, time);
			if (result.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(result);
		}
		
		// Average measurements for a user grouped by hour, over last 7 days from time
		@GetMapping("/api/v1/patient/{userId}/getData/average/ForWeek/{time}")
		public ResponseEntity<List<Measurement>> findAvgByUserIdForWeek(@PathVariable long userId, @PathVariable String time) {
			List<Measurement> result =MeasurementRepository.findAvgByUserIdForWeek(userId, time);
			if (result.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(result);
		}
		// Average measurements for a user grouped by Day, over last  month from time
				@GetMapping("/api/v1/patient/{userId}/getData/average/ForMonth/{time}")
				public ResponseEntity<List<Measurement>> findAvgByUserIdForMonth(@PathVariable long userId, @PathVariable String time) {
					List<Measurement> result =MeasurementRepository.findAvgByUserIdForMonth( userId,time);
					if (result.isEmpty()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(result);
		}
				// Average measurements for a user grouped by Week, over last  Year from time
				@GetMapping("/api/v1/patient/{userId}/getData/average/ForYear/{time}")
				public ResponseEntity<List<Measurement>> findAvgByUserIdForYear(@PathVariable long userId, @PathVariable String time) {
					List<Measurement> result =MeasurementRepository.findAvgByUserIdForYear(userId, time);
					if (result.size()<=1) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(result);
		}
				// Average measurements for a user grouped by Month, over All Time from time
				@GetMapping("/api/v1/patient/{userId}/getData/average/ForAllTime/{time}")
				public ResponseEntity<List<Measurement>> findAvgByUserIdForAllTime(@PathVariable long userId, @PathVariable String time) {
					List<Measurement> result =MeasurementRepository.findAvgByUserIdForAllTime(userId, time);
					if (result.size()<=1) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(result);
		}
	
				
				
	
	/*****************************************************************
	 * GETTING VERY HIGH / HIGH / TARGET / LOW / VERY LOW PERCENTAGES*
	 *****************************************************************/
	
	// Critical values
	@GetMapping("/api/v1/patient/{userId}/getData/criticalLevels/{date}")
	public ResponseEntity<Object> criticalLevels(@PathVariable long userId, @PathVariable String date) {
		Object result = MeasurementRepository.getPercentageQuery(userId, date);
		return ResponseEntity.ok(result);
	}

	
	


}
