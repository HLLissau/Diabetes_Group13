package group13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
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
	@Column
	private Doctor doctor;
	
	public User() {
	}
	
	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return ((User) obj).id.equals(this.id);
		}
		return false;
	}
}
