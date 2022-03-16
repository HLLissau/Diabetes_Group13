package dtu.group13.acceptance_tests;

import group13.Application;
import group13.model.Hospital;
import group13.model.Patient;

public class Patient_Helper {
	private Application application;
	private Hospital hospital;
	private Patient patient;
	
	public Patient_Helper(Application application) {
		this.application = application;
		this.hospital = hospital;
	}
	
	public Patient getPatient() {
		if (patient==null) {
			patient=examplePatient("Hans erik");
		}
		return patient;
	}
	public Patient examplePatient(String name) {
		return new Patient(name);
	}
}


