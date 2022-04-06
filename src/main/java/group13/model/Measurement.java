package group13.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private int userId;
	@Column
	private Timestamp time;
	@Column
	private Date date;
	@Column
	private int deviceId;
	@Column
	private double meals;
	@Column
	private double exercise;
	@Column
	private double basal;
	@Column
	private double bolus;

	
	
}
