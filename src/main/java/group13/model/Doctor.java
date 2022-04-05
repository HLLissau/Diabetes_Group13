package group13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Doctor extends User {
	
	@Column
	private List<User> patients;
	
	public void addPatient(User patient) {
		this.patients.add(patient);
	}
	
	public void deletePatient(User patient) {
		this.patients.remove(patient);
	}
	
	public List<User> getPatients(){
		return this.patients;
	}
	
	

}
