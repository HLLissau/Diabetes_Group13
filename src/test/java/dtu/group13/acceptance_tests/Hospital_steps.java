package dtu.group13.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;

import group13.Application;
import group13.model.Hospital;
import group13.model.Patient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hospital_steps {
	private Application application;
	private Hospital hospital;
	private Patient patient;
	private Patient_Helper patient_helper;
	private List<Patient> patientList;
	
	
	public Hospital_steps(Application application) {
		this.application=application;
		this.patient_helper= new Patient_Helper(application);
		}
	
//	@Given("that the administrator is logged in")
//	public void thatTheAdministratorIsLoggedIn() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("there is a patient called {string}")
	public void thereIsAPatientCalled(String string) {
	    patient = patient_helper.examplePatient(string);
	}

	@Given("a hospital called {string}")
	public void aHospitalCalled(String name) {
	    hospital=new Hospital(name);
	}

	@Given("the Patient is not in the hospital list")
	public void thePatientIsNotInTheHospitalList() {
	    patientList = this.hospital.getPatients();
	    assertFalse(patientList.contains(patient));
	}

	@When("the patient is added to the hospital")
	public void thePatientIsAddedToTheHospital() {
	    hospital.addPatient(patient);
	}

	@Then("the patient called {string} is added to the hospital")
	public void thePatientCalledIsAddedToTheHospital(String name) {
		patientList = this.hospital.getPatients();
		Boolean value=false;
		for (Patient x : patientList) {
	    	value = x.getName().equals(name) || value;
	    }
	    assertTrue(value);
	}
}
