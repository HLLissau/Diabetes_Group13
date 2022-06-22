package group13.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import group13.model.Doctor;
import group13.model.Treats;
import group13.model.Users;
import group13.repositories.DoctorRepository;
import group13.repositories.TreatsRepository;

@Controller
@CrossOrigin
public class TreatsController {
	
	@Autowired
	private TreatsRepository repository;
	@Autowired
	private DoctorRepository doctorRepository;
	

	
	//get the doctor of a patient
	@GetMapping("/api/v1/patient/getDoctor/{patientId}")
	public ResponseEntity<List<Doctor>> getDoctor(@PathVariable Long patientId) {
		List<Doctor> p = doctorRepository.getDoctor(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		for(Doctor doctor: p) {
			doctor.setPassword("");
		}
		return ResponseEntity.ok(p);	
		}
	
	
	

}
