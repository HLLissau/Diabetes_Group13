package group13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import group13.model.Hospital;
import group13.model.Patient;
import group13.repositories.HospitalRepository;
import group13.repositories.PatientRepository;

@Controller
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientRepository repository;
	@Autowired
	private HospitalRepository repositoryHospital;
	
	
	
	@GetMapping("/api/v1/hospitals/{hospitalId}/patients")
	public ResponseEntity<List<Patient>> getAll(@PathVariable Long hospitalId) {
		Optional<Hospital> h = repositoryHospital.findById(hospitalId);
		if (h.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(h.get().getPatients());
		}
	@PostMapping("/api/v1/hospitals/{hospitalId}/patients")
	public ResponseEntity<Patient> create(@RequestBody Patient patient,@PathVariable Long hospitalId){
		Optional<Hospital> h = repositoryHospital.findById(hospitalId);
		if (h.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		h.get().addPatient(patient);
		return ResponseEntity.ok(repository.save(patient));
	}
	
	@DeleteMapping("/api/v1/hospitals/{hospitalId}/patients/{patientId}")
	public ResponseEntity<?> delete(@PathVariable Long hospitalId,@PathVariable Long patientId) {
		Optional<Hospital> h = repositoryHospital.findById(hospitalId);
		if (h.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Patient> p = repository.findById(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		h.get().removePatient(p.get());
		repositoryHospital.save(h.get());
		return ResponseEntity.noContent().build();
	}
}