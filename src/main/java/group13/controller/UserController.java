package group13.controller;

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

import group13.model.Doctor;
import group13.model.User;
import group13.repositories.DoctorRepository;
import group13.repositories.UserRepository;

@Controller
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private DoctorRepository doctorRepository;

	// create user
	@PostMapping("/api/v1/login/create/user")
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(repository.save(user));
	}

	// get user
	@GetMapping("/api/v1/login/get/{patientId}")
	public ResponseEntity<Doctor> getUser(@PathVariable Long patientId) {
		Optional<Doctor> p = doctorRepository.findById(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p.get());
	}

	// delete user
	@DeleteMapping("/api/v1/login/delete/{patientId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long patientId) {
		Optional<User> p = repository.findById(patientId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.delete(p.get());
		return ResponseEntity.noContent().build();
	}

}