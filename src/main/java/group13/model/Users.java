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
	private String email;
	@Column 
	private String password;

	@Column
	private Timestamp createdAt;
	
	public Users() {
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}
	
	public Users(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getName() {
		return this.fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Users) {
			return ((Users) obj).id.equals(this.id);
		}
		return false;
	}
}
