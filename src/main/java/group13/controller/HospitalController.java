package group13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import group13.model.Hospital;
import group13.repositories.HospitalRepository;

@Controller
@CrossOrigin
public class HospitalController {
	
	@Autowired
	private HospitalRepository repository;
	
	@GetMapping("/api/v1/hospitals")
	public ResponseEntity<List<Hospital>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
}
