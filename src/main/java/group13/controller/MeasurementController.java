package group13.controller;




import java.math.BigInteger;
import java.sql.Timestamp;
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
		List<Measurement> result =MeasurementRepository.findAllByUserId(userId);
		return ResponseEntity.ok(result);
	}
	
	// Get all measurements for a user within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> getData(@PathVariable long userId, @PathVariable String startDate, @PathVariable String endDate) {
		List<Measurement> result =MeasurementRepository.findByUserIdByTimeBetween(userId,startDate,endDate);
		return ResponseEntity.ok(result);
	}
//	

/********************
 * GETTING AVERAGES *	
 ********************/
	
    // Average measurements for a user over each hour within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byHour/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByHour(@PathVariable long userId, @PathVariable String startDate, @PathVariable String endDate) {
		List<Measurement> result =MeasurementRepository.findAvgByUserIdByHourByTimeBetween(userId, startDate, endDate);
	    return ResponseEntity.ok(result);
	}
	
	// Average measurements for a user over each day within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byDay/{startDate}/{endDate}")
	public ResponseEntity<List<Measurement>> averageByDay(@PathVariable long userId, @PathVariable String startDate, @PathVariable String endDate) {
		List<Measurement> result =MeasurementRepository.findAvgByUserIdByDayByTimeBetween(userId, startDate, endDate);
		return ResponseEntity.ok(result);
	}
	
	// Average measurements for a user over each week within a time interval
	@GetMapping("/api/v1/patient/{userId}/getData/average/byWeek")
	public ResponseEntity<List<Measurement>> averageByWeek(@PathVariable long userId) {
		List<Measurement> result =MeasurementRepository.findAvgByWeekForUserId(userId);
		return ResponseEntity.ok(result);
	}
}
