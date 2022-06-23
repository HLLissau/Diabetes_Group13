package group13.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String fullName;
	@Column 
	private String password;

	@Column
	private Timestamp createdAt;
	@Column(unique=true)
	private String email;
	public Users() {
		
	}
	
	public Users(Long id,String name,String password,String email ){
		this.id=id;
		this.fullName=name;
		this.password=password;
		this.email= email;
	}
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Timestamp getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Users) {
			return ((Users) obj).id.equals(this.id);
		}
		return false;
	}
}
