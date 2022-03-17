package group13.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@OneToMany
	private List<Patient> patients=new ArrayList<Patient>();
	
	public Hospital() {
		
		}
	
	public Hospital(String name) {
		this.name=name;
	}
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
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Hospital) {
			return (((Hospital) obj).id.equals(this.id));
		}
		return false;
	}
	
	
}
