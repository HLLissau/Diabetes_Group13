package group13.controller;




import java.math.BigInteger;
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

	@GetMapping("/api/v1/patient/{patientId}/getData")
	public ResponseEntity<List<Measurement>> getall(@PathVariable Long patientId) {
		List<Measurement> result =MeasurementRepository.findAllByUserId(patientId);
		return ResponseEntity.ok(result);
	}
	
//	// Get data of dataType in the period of time startDate - endDate
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/{startDate}/{endDate}")
//	public ResponseEntity<Measurement> getData(@PathVariable long patientId, @PathVariable long dataType, @PathVariable long startDate, @PathVariable long endDate) {
//		return null;
//		
//	}
//	
// Get averages:
// By day
	@GetMapping("/api/v1/patient/{user_Id}/getData/average/byDay")
	public ResponseEntity<List<Measurement>> averageByDay(@PathVariable long user_Id) {
		List<Measurement> result =MeasurementRepository.findAvgByDayForUserId(user_Id);
	return ResponseEntity.ok(result);
		
	}
	
	// By week
	@GetMapping("/api/v1/patient/{user_Id}/getData/average/byWeek")
	public ResponseEntity<List<Measurement>> averageByWeek(@PathVariable long user_Id) {
		List<Measurement> result =MeasurementRepository.findAvgByWeekForUserId(user_Id);
		return ResponseEntity.ok(result);
		
	}
	
//	// By month
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/average/byMonth")
//	public ResponseEntity<Data> averageByMonth(@PathVariable long patientId, @PathVariable long dataType) {
//		return null;
//		
//	}
//	
//	// By year
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/average/byDay")
//	public ResponseEntity<Data> averageByYear(@PathVariable long patientId, @PathVariable long dataType) {
//		return null;
//		
//	}


}
