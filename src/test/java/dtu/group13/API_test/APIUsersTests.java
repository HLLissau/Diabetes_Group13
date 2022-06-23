package dtu.group13.API_test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import group13.Application;
import group13.controller.DoctorController;
import group13.controller.UserController;
import group13.model.Doctor;
import group13.model.Users;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class APIUsersTests {
	
	@Autowired
	@Mock
	private UserController controller;
	@Mock
	private DoctorController doctorController;
	private Doctor doctor =new Doctor();
	private Users user=new Users(1133L,"test1","password","email@test,com");
	private ResponseEntity response;

	
	
    
	//is the controller loaded?
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	@Test 
	public void getReturnObject() throws Exception {
		response =controller.getAll();
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
	}
	//post a user
	@Test
	public void PostAddsItem() throws Exception {
		ResponseEntity response = controller.getAll();
		int lenght =((List<Users>) response.getBody()).size();	
		response= controller.create(user);
		assertThat(response.getStatusCode().equals(200));
		response =controller.getAll();
		List<Users> reply = (List<Users>) response.getBody();
		assertEquals(lenght+1,reply.size());
		assertThat(reply.contains(user));
	}
	
	//post a user that have duplicate email
	@Test
	public void PostAddsItemAlreadyExist() throws Exception {
			ResponseEntity response = controller.getAll();
			int lenght =((List<Users>) response.getBody()).size();	
			response= controller.create(user);
			assertEquals(response.getStatusCode().value(),200);
			response =controller.getAll();
			List<Users> reply = (List<Users>) response.getBody();
			assertEquals(lenght,reply.size());
		}
		
	//get user by id
	@Test 
	public void getUsersObject() throws Exception {
		response =controller.getUser(user.getId());
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
	}
	//get user by id that is not in database
		@Test 
		public void getUsersObjectNotInDatabase() throws Exception {
			response =controller.getUser(99999L);
			assertEquals(response.getStatusCode().value(),404);
			assertNull(response.getBody());
		}
		
	//delete a user
	@Test
	public void DeleteAnItemThatExists() throws Exception {
		int lenght = controller.getAll().getBody().size();
		ResponseEntity<Users> response= controller.getUser(user.getId());
		assertThat(response.getStatusCode().equals(200));
		controller.deleteUser(user.getId(),user.getPassword());
		assertThat(response.getStatusCode().equals(200));
		assertEquals(controller.getAll().getBody().size(),lenght-1);
		assertFalse(controller.getAll().getBody().contains(user));
	}

	//delete a user
	@Test
	public void DeleteAnItemThatExistsWrongPassword() throws Exception {
		int lenght = controller.getAll().getBody().size();
		ResponseEntity<Users> response= controller.getUser(user.getId());
		assertThat(response.getStatusCode().equals(200));
		controller.deleteUser(user.getId(),"Wrong password");
		assertEquals(response.getStatusCode().value(),200);
		assertEquals(controller.getAll().getBody().size(),lenght);
		assertThat(controller.getAll().getBody().contains(user));
	}
	
	
	//login with correct password
	@Test
	public void LoginWithCorrectPassword() throws Exception {
		Users user = controller.getAll().getBody().get(0);
		ResponseEntity<Users> response = controller.loginUser(user.getEmail(), user.getPassword());
		System.out.println(response.getStatusCode());
		
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(user));
	}
	//login with Incorrect password
		@Test
		public void LoginWithInCorrectPassword() throws Exception {
			Users user = controller.getAll().getBody().get(0);
			ResponseEntity<Users> response = controller.loginUser("Wrong Email", user.getPassword());
			System.out.println(response.getStatusCode());
		
			assertEquals(response.getStatusCode().value(),404);
			assertNull(response.getBody());
		}
		
		//update User
				@Test
				public void UpdateUser() throws Exception {
					Users user = controller.getAll().getBody().get(0);
					ResponseEntity<Users> response = controller.updateUser(user.getId(),user.getFullName(),user.getEmail(), user.getPassword(),user.getPassword());
					assertThat(response.getStatusCode().equals(200));
					assertThat(response.getBody().equals(user));
				}
				//update User Wrong password
				@Test
				public void UpdateUserWrongPassword() throws Exception {
					Users user = controller.getAll().getBody().get(0);
					user.setPassword("Wrong Password");
					ResponseEntity<Users> response = controller.updateUser(user.getId(),user.getFullName(),user.getEmail(), "Wrong Password","cant change");
					assertEquals(response.getStatusCode().value(),404);
					assertNull(response.getBody());
				}
				
//				// Is user logged in
//				@Test
//				public void loggedIn(Long id,String password) {
//				  ResponseEntity<Users> response =controller.getUser(id);
//				  assertEquals(200,response.getStatusCode().value());
//				  assertEquals(password,response.getBody().getPassword())
} 
