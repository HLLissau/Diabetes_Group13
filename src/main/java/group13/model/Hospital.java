package group13.model;

import java.util.List;

public class Hospital {
	private Long id;
	private String name;
	private List<Patient> patients;
	
	
	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}
	public void removePatient(Patient patient) {
		this.patients.remove(patient);
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
}
