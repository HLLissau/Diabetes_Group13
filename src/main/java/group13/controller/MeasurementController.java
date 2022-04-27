package group13.controller;


import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import group13.model.Measurement;
import group13.model.Doctor;
import group13.model.Users;
import group13.repositories.DoctorRepository;
import group13.repositories.UserRepository;
import group13.repositories.MeasurementRepository;

@Controller
@CrossOrigin
public class MeasurementController {
	
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private MeasurementRepository MeasurementRepository;

	@GetMapping("/api/v1/patient/{patientId}/getData/{datatype}")
	public ResponseEntity<java.util.List<Measurement>> getall(@PathVariable Long patientId, @PathVariable String datatype) {
		return ResponseEntity.ok(MeasurementRepository.findAllByUserID(patientId));
	}
//	// Get data of dataType in the period of time startDate - endDate
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/{startDate}/{endDate}")
//	public ResponseEntity<Measurement> getData(@PathVariable long patientId, @PathVariable long dataType, @PathVariable long startDate, @PathVariable long endDate) {
//		return null;
//		
//	}
//	
//	// Get averages:
//	// By day
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/average/byDay")
//	public ResponseEntity<Data> averageByDay(@PathVariable long patientId, @PathVariable long dataType) {
//		return null;
//		
//	}
//	
//	// By week
//	@GetMapping("/api/v1/patient/{patientId}/getData/{dataType}/average/byWeek")
//	public ResponseEntity<Data> averageByWeek(@PathVariable long patientId, @PathVariable long dataType) {
//		return null;
//		
//	}
//	
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
