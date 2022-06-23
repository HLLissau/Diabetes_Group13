package dtu.group13.API_test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import group13.Application;
import group13.controller.DoctorController;

import group13.controller.TreatsController;
import group13.controller.UserController;
import group13.model.Doctor;

import group13.model.Users;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class APITreatsTest {


	
	@Autowired
	private TreatsController treatsController;
	@Autowired
	private UserController userController;
	
	private DoctorController doctorController;
	
	
	private Doctor doctor =new Doctor();
	private Users user=new Users(1133L,"test1","password","email@test,com");
	private ResponseEntity response;
	

	//is the controller loaded?
	@Test
	public void contextLoads() throws Exception {
		assertThat(treatsController).isNotNull();
	}
//	@Test 
//	public void getReturnObject() throws Exception {
//		response = treatsController.getAllTreats();
//		assertEquals(response.getStatusCode().value(),200);
//		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
//	}
	
	
	//retrieve doctor of patient
	@Test
	public void getListTest() {
		ResponseEntity<List<Users>> response =userController.getAll();
		assertEquals(response.getStatusCode().value(),200);
		user = response.getBody().get(0);
		ResponseEntity<List<Doctor>> response2 = treatsController.getDoctor(user.getId());
		assertEquals(response2.getStatusCode().value(),200);
		assertNotNull(response2.getBody());
		
	}
	
	//retrieve doctor of patient that does not exist
		@Test
		public void getListTestOfNonExistingUser() {
			ResponseEntity<List<Doctor>> response2 = treatsController.getDoctor(new Users().getId());
			assertEquals(response2.getStatusCode().value(),404);
			assertNull(response2.getBody());
			
		}
}









