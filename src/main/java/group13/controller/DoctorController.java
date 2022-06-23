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
	@Autowired
	private UserRepository patientRepository;
	@Autowired
	private TreatsRepository treatsrepository;
	
	//getAll
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		return ResponseEntity.ok(doctorRepository.findAll());
		}

	//getById
	public ResponseEntity<Doctor> getDoctor(Long Id){
		Optional<Doctor> d = doctorRepository.findById(Id);
		if (!d.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		d.get().setPassword("");
		return ResponseEntity.ok(d.get());
	}
	
	
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

		// get all patients of a doctor
		@GetMapping("/api/v1/Doctor/{doctorId}/getPatients")
		public ResponseEntity<List<Users>> getPatients(@PathVariable Long doctorId) {
			Optional<Doctor> d = doctorRepository.findById(doctorId);
			
	    if (!d.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			 List<Users> p = patientRepository.getPatients(doctorId);
		     
			return ResponseEntity.ok(p);	
			}
		
		// get all patients of a doctor
						 	      
			@GetMapping("/api/v1/Doctor/{doctorId}/getPatientInfo/{userId}")
			public ResponseEntity<Users> getPatientInfo(@PathVariable Long doctorId,@PathVariable Long userId) {
			 	
				Optional<Treats> p = treatsrepository.findById(doctorId,userId);
				
			    if (!p.isPresent()) {
					return ResponseEntity.notFound().build();
				}
			    Optional<Users> u = patientRepository.findById(userId);
		
			  	return ResponseEntity.ok(u.get());	
				}
	
	// delete doctor
	@DeleteMapping("/api/v1/doctor/delete/{doctorId}/{password}")
	public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId,@PathVariable String password) {
		Optional<Doctor> d = doctorRepository.findByIdAndPassword(doctorId,password);
		if (!d.isPresent()) {
			return ResponseEntity.notFound().build();
		}
//		ResponseEntity<List<Users>> treats = this.getPatients(d.get().getId());
//		while (!treats.getBody().isEmpty()) {
//			
//			d.get().deletePatient(d.get().getPatients().get(0));
//		}
		doctorRepository.delete(d.get());
		return ResponseEntity.noContent().build();
	}

	// remove patient
//	@PutMapping("/api/v1/doctor/remove/{patientId}/{doctorId}")
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