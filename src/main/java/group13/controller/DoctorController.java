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
import group13.model.Treats;
import group13.model.Users;
import group13.repositories.DoctorRepository;
import group13.repositories.TreatsRepository;
import group13.repositories.UserRepository;

@Controller
@CrossOrigin
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;
	

	// create doctor
	@PostMapping("/api/v1/doctor/create")
	public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorRepository.save(doctor));
	}
	
	
	//login Doctor
		@GetMapping("/api/v1/login/loginDoctor/{Email}/{password}")
		public ResponseEntity<Doctor> loginDoctor(@PathVariable String Email,@PathVariable String password){
			
			//System.out.println("userid: "+ userId + ". password: " + password);
					
			Optional<Doctor> p = doctorRepository.loginDoctor(Email,password);
			if (!p.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(p.get());
			
		}


	
	// get doctors of user
		@GetMapping("/api/v1/patient/getDoctor/{patientId}")
		public ResponseEntity<List<Doctor>> getDoctor(@PathVariable Long patientId) {
			List<Doctor> p = doctorRepository.getDoctor(patientId);
			if (p.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(p);	
			}
//
//	// delete doctor
//	@DeleteMapping("/api/v1/login/delete/{patientId}")
//	public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
//		Optional<Doctor> d = doctorRepository.findById(doctorId);
//		if (d.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//		while (!d.get().getPatients().isEmpty()) {
//			
//			d.get().deletePatient(d.get().getPatients().get(0));
//		}
//		doctorRepository.delete(d.get());
//		return ResponseEntity.noContent().build();
//	}
//
//	// return patients of doctor {doctorId}
//	@GetMapping("/api/v1/doctor/{doctorId}/patients")
//	public ResponseEntity<List<User>> getAll(@PathVariable Long doctorId) {
//		Optional<Doctor> d = doctorRepository.findById(doctorId);
//		if (d.isEmpty() || d.get().getPatients().isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(d.get().getPatients());
//	}
//	
//	
	// remove patient
//	@PutMapping("/api/v1/remove/patient/{patientId}/{doctorId}")
//	public ResponseEntity<?> removePatient(@PathVariable Long patientId, @PathVariable Long doctorId) {
//		Optional<User> p = repository.findById(patientId);
//		Optional<Doctor> d = doctorRepository.findById(doctorId);
//		if (p.isEmpty() || d.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//		if(d.get().getPatients().contains(p.get())) {
//			d.get().deletePatient(p.get());
//			
//		}
//		return (ResponseEntity<?>) ResponseEntity.ok();
//	}
//	
//	

}