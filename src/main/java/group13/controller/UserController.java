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
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TreatsRepository treatsrepository;
	
	
	// create user
	@PostMapping("/api/v1/patient/create")
	public ResponseEntity<Users> create(@RequestBody Users user) {
		repository.save(user);
		Optional<Users> u = repository.loginUser(user.getEmail(), user.getPassword());
		if (u.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u.get());
	}

	// get user
	@GetMapping("/api/v1/login/get/user/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable Long userId) {
		Optional<Users> p = repository.findById(userId);
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		p.get().setPassword("");
		return ResponseEntity.ok(p.get());
	}
	
//	// get users
//	@GetMapping("/api/v1/login/get/users")
//	public ResponseEntity<List<Users>> getUsers() {
//		return ResponseEntity.ok(repository.findAll());
//	}

	// delete user
//	@DeleteMapping("/api/v1/patient/delete/{userId}")
//	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
//		Optional<Users> p = repository.findById(userId);
//		if (!p.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		System.out.println("test");
//		repository.delete(p.get());
//		return ResponseEntity.noContent().build();
//	}
	// delete user
		@DeleteMapping("/api/v1/patient/delete/{userId}/{password}")
		public ResponseEntity<?> deleteUser2(@PathVariable Long userId,@PathVariable String password) {
			Optional<Users> p = repository.findByIdAndPassword(userId,password);
			if (!p.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			System.out.println("test");
			repository.delete(p.get());
			return ResponseEntity.noContent().build();
		}
	//login User
	@GetMapping("/api/v1/login/loginUser/{email}/{password}")
	public ResponseEntity<Users> loginUser(@PathVariable String email,@PathVariable String password){
		
		//System.out.println("userid: "+ userId + ". password: " + password);
				
		Optional<Users> p = repository.loginUser(email,password);
		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p.get());
		
	}
	
	//change name
		@GetMapping("/api/v1/user/update/{userId}/{name}/{email}/{password}")
		public ResponseEntity<Users> changeName(@PathVariable Long userId,
				@PathVariable String name,
				@PathVariable String email,
				@PathVariable String password){
			
			//System.out.println("userid: "+ userId + ". password: " + password);
					
			Optional<Users> p = repository.updateUser(userId,name,email,password);
			if (!p.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(p.get());
			
		}
		
		

}