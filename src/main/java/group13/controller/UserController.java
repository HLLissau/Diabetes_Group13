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
import group13.model.Users;
import group13.repositories.TreatsRepository;
import group13.repositories.UserRepository;

@Controller
@CrossOrigin
public class UserController { //Erik s204438

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TreatsRepository treatsrepository;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	// create user
	@PostMapping("/api/v1/patient/create")
	public ResponseEntity<Users> create(@RequestBody Users user) {
		repository.save(user);
		
		Optional<Users> u = repository.loginUser(user.getEmail(), user.getPassword());
		if (!u.isPresent()) {
			
		}
		return ResponseEntity.ok(u.get());
	}

	// get user
	@GetMapping("/api/v1/login/get/user/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable Long userId) {
		Optional<Users> p = repository.findById(userId);
		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		p.get().setPassword("");
		return ResponseEntity.ok(p.get());
	}
	
		@DeleteMapping("/api/v1/patient/delete/{userId}/{password}")
		public ResponseEntity<?> deleteUser(@PathVariable Long userId,@PathVariable String password) {
			Optional<Users> p = repository.findByIdAndPassword(userId,password);
			if (!p.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			repository.delete(p.get());
			return ResponseEntity.noContent().build();
		}
	//login User
	@GetMapping("/api/v1/login/loginUser/{email}/{password}")
	public ResponseEntity<Users> loginUser(@PathVariable String email,@PathVariable String password){
		
		System.out.println("email: "+ email + " password: " + password);
				
		Optional<Users> p = repository.loginUser(email,password);
		if (!p.isPresent()) {
			System.out.println("error");
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.ok(p.get());
		
	}
	
	//change name
		@GetMapping("/api/v1/user/update/{userId}/{name}/{email}/{oldPassword}/{newPassword}")
		public ResponseEntity<Users> updateUser(
				@PathVariable Long userId,
				@PathVariable String name,
				@PathVariable String email,
				@PathVariable String oldPassword,
				@PathVariable String newPassword)
		{
			
			System.out.println("userid: "+ userId + ". oldpassword: " + oldPassword  + ".New:" + newPassword);
					
			Optional<Users> p = repository.updateUser(userId,name,email,oldPassword,newPassword);
			if (!p.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(p.get());
			
		}
		
		

}