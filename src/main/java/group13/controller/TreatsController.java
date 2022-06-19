package group13.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import group13.model.Treats;
import group13.repositories.TreatsRepository;

@Controller
@CrossOrigin
public class TreatsController {
	
	@Autowired
	private TreatsRepository repository;
	
	
	// get doctor of user
	@GetMapping("/api/v1/patient/getDoctor/{patientId}")
	public ResponseEntity<Object> getDoctor(@PathVariable Long patientId) {
		Optional<Treats> p = repository.findId(patientId);
		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p);	
		}

}
