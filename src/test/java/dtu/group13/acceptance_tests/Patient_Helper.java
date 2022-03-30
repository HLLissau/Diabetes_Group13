package dtu.group13.acceptance_tests;

import group13.Application;
import group13.model.Hospital;
import group13.model.User;

public class Patient_Helper {
	private Application application;
	private Hospital hospital;
	private User patient;
	
	public Patient_Helper(Application application) {
		this.application = application;
		this.hospital = hospital;
	}
	
	public User getPatient() {
		if (patient==null) {
			patient=examplePatient("Hans erik");
		}
		return patient;
	}
	public User examplePatient(String name) {
		return new User(name);
	}
}


