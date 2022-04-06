package group13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor  {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	//@Column
	//private List<User> patients;
//	
//	public void addPatient(User patient) {
//		this.patients.add(patient);
//	}
//	
//	public void deletePatient(User patient) {
//		this.patients.remove(patient);
//	}
//	
//	public List<User> getPatients(){
//		return this.patients;
//	}
//	
	

}
