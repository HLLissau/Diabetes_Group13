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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String fullName;
	@Column
	private Timestamp createdAt;
	
	public User() {
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
	

	

	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Users) {
			return ((Users) obj).id.equals(this.id);
		}
		return false;
	}
}
