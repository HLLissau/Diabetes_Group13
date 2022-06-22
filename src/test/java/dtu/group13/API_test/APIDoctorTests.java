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
import org.mockito.InjectMocks;
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
public class APIDoctorTests {
	
	@Mock
	@Autowired
	private DoctorController doctorController;
	private Doctor doctor =new Doctor(26233L,"test1","password","email22@test,com");
	private Users user=new Users(1133L,"test1","password","email@test,com");
	private ResponseEntity response;

	@Autowired
	@Mock
	private UserController userController;
	
	@Autowired
	@Mock
	private TreatsController treatsController;
	
	
    
	//is the controller loaded?
	@Test
	public void contextLoads() throws Exception {
		assertThat(doctorController).isNotNull();
	}
	@Test 
	public void getReturnObject() throws Exception {
		response =doctorController.getAllDoctor();
		System.out.println(response);
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
	}
	//post a doctor
	@Test
	public void PostAddsItem() throws Exception {
		ResponseEntity response = doctorController.getAllDoctor();
		int lenght =((List<Users>) response.getBody()).size();	
		response= doctorController.create(doctor);
		assertEquals(response.getStatusCode().value(),200);
		ResponseEntity<List<Doctor>> response2 =doctorController.getAllDoctor();
		List<Doctor> reply =  response2.getBody();
		assertEquals(lenght+1,reply.size());
		assertThat(reply.contains(doctor));
	}
	
	//post a doctor that already exist
	@Test
	public void PostAddsItemAlreadyExist() throws Exception {
		ResponseEntity response = doctorController.getAllDoctor();
		int lenght =((List<Users>) response.getBody()).size();	
		response= doctorController.create(doctor);
		assertThat(response.getStatusCode().equals(200));
		response =doctorController.getAllDoctor();
		List<Doctor> reply = (List<Doctor>) response.getBody();
		assertEquals(lenght,reply.size());
		}
		
	//get user by id
	@Test 
	public void getUsersObject() throws Exception {
		response =doctorController.getDoctor(doctor.getId());
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
	}
	//get user by id that is not in database
		@Test 
		public void getUsersObjectNotInDatabase() throws Exception {
			response =doctorController.getDoctor(99999L);
			assertEquals(response.getStatusCode().value(),404);
			assertNull(response.getBody());
		}
		
	//delete a doctor
	@Test
	public void DeleteAnItemThatExists() throws Exception {
		int lenght = doctorController.getAllDoctor().getBody().size();
		ResponseEntity<Doctor> response= doctorController.getDoctor(doctor.getId());
		assertEquals(response.getStatusCode().value(),200);
		doctorController.deleteDoctor(doctor.getId(),doctor.getPassword());
		assertEquals(doctorController.getAllDoctor().getBody().size(),lenght-1);
		assertFalse(doctorController.getAllDoctor().getBody().contains(doctor));
	}

	//delete a doctor with wrong password
	@Test
	public void DeleteAnItemThatExistsWrongPassword() throws Exception {
		int lenght = doctorController.getAllDoctor().getBody().size();
		ResponseEntity<Doctor> response= doctorController.getDoctor(doctor.getId());
		assertEquals(response.getStatusCode().value(),200);
		doctorController.deleteDoctor(doctor.getId(),"Wrong password");
		assertEquals(response.getStatusCode().value(),200);
		assertEquals(doctorController.getAllDoctor().getBody().size(),lenght);
		assertThat(doctorController.getAllDoctor().getBody().contains(doctor));
	}
	
	
	//login with correct password
	@Test
	public void LoginWithCorrectPassword() throws Exception {
		Doctor doctor = doctorController.getAllDoctor().getBody().get(0);
		ResponseEntity<Doctor> response = doctorController.loginDoctor(doctor.getEmail(), doctor.getPassword());
		System.out.println(response.getStatusCode());
		
		assertEquals(response.getStatusCode().value(),200);
		assertThat(response.getBody().equals(doctor));
	}
	//login with Incorrect password
		@Test
		public void LoginWithInCorrectPassword() throws Exception {
			Doctor doctor = doctorController.getAllDoctor().getBody().get(0);
			ResponseEntity<Doctor> response = doctorController.loginDoctor("Wrong Email",doctor.getPassword());
			System.out.println(response.getStatusCode());
		
			assertEquals(response.getStatusCode().value(),404);
			assertNull(response.getBody());
		}
	//get patient list
	@Test
	public void getListofPatients() throws Exception {
		ResponseEntity<List<Users>>  response = doctorController.getPatients(doctor.getId());
		assertEquals(response.getStatusCode().value(),200);
		
	}
	//Doctor does not exist
	@Test
	public void getListofPatientsError() throws Exception {
		ResponseEntity<List<Users>>  response = doctorController.getPatients(9999959L);
		assertEquals(response.getStatusCode().value(),404);
	}
	//get patient info
	@Test
	public void getinfoOfPatients() throws Exception {
		Doctor doctor1 = doctorController.getAllDoctor().getBody().get(0);
		Users user1 = doctorController.getPatients(doctor1.getId()).getBody().get(0);
		assertNotNull(user1);
		ResponseEntity<Users> response = doctorController.getPatientInfo(doctor1.getId(), user1.getId());
		assertEquals(response.getStatusCode().value(),200);
		assertEquals(response.getBody(),user1);
		
	}
	//get patient info for relation not in treats
		@Test
		public void getinfoOfPatientsNotInTreats() throws Exception {
			ResponseEntity<Users> response = doctorController.getPatientInfo(doctor.getId(), user.getId());
			assertEquals(response.getStatusCode().value(),404);
			assertNull(response.getBody());
			
		}

}
	
	
	
	
