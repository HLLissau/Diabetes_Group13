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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import group13.model.Doctor;
import group13.model.Hospital;
import group13.model.User;
import group13.repositories.HospitalRepository;
import group13.repositories.UserRepository;

@Controller
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	
	
	@GetMapping("/api/v1/doctor/{doctorId}/patients")
	public ResponseEntity<List<User>> getAll(@PathVariable Long doctorId) {
		//Optional<Hospital> h = repositoryHospital.findById(doctorId);
		if (h.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(h.get().getPatients());
		}
	
	@PostMapping("/api/v1/login/user")
	public ResponseEntity<User> create(@RequestBody User user){
		return ResponseEntity.ok(repository.save(user));
	}
	
	@PostMapping("/api/v1/login/doctor")
	public ResponseEntity<User> create(@RequestBody Doctor doctor){
		return ResponseEntity.ok(repository.save(doctor));
	}
	
	@DeleteMapping("/api/v1/login/{patientId}")
	public ResponseEntity<?> delete(@PathVariable Long patientId) {
		Optional<User> p = repository.findById(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		p.get().getDoctor().deletePatient(p.get());
		repository.delete(p.get());
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/api/v1/{patientId}/{doctorId}")
	public ResponseEntity<?> assignDoctor(@PathVariable Long patientId, @PathVariable Long doctorId) {
		Optional<User> p = repository.findById(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Optional<User> d = repository.findById(doctorId);
		if (d.isEmpty() || !(d.get() instanceof Doctor)) {
			return ResponseEntity.notFound().build();
		}
		//Der ligger kun User i UserRepository og altså ingen Doctor
		p.get().setDoctor(d.get());
	}
	
}