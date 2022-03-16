package dtu.group13.API_test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import group13.Application;
import group13.controller.HospitalController;
import group13.controller.PatientController;
import group13.model.Hospital;
import group13.model.Patient;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class APIHospitalSteps {
	
	@Autowired
	private HospitalController controller;
	
	private Patient patient=new Patient("Hans");
	private Hospital hospital=controller.create(new Hospital("angel")).getBody();
	
	
	private ResponseEntity response;

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
	@Test
	public void PostAddsItem() throws Exception {
		int lenght = controller.getAll().getBody().size();
		response= controller.create(hospital);
		assertThat(response.getStatusCode().equals(200));
		response =controller.getAll();
		ArrayList<Hospital> reply = (ArrayList<Hospital>) response.getBody();
		assertEquals(lenght+1,reply.size());
		assertThat(reply.contains(hospital));
	}
	@Test
	public void DeleteAnItemThatExists() throws Exception {
		int lenght = controller.getAll().getBody().size();
		hospital = ((ArrayList<Hospital>) controller.getAll().getBody()).get(0);
		controller.delete(hospital.getId());
		assertEquals(controller.getAll().getBody().size(),lenght-1);
		assertFalse(controller.getAll().getBody().contains(hospital));
	}
		
}
	
	
	
	
