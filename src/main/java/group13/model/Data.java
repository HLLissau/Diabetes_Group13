package group13.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	
	
}
