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
	private int user_Id;
	@Column
	private Timestamp time;
	//@Column
	//private Date date;
	@Column
	private Integer device_Id;
	@Column
	private Double meals;
	@Column
	private Double exercise;
	@Column
	private Double basal;
	@Column
	private Double bolus;
	@Column 
	private Double measurement;
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getDevice_Id() {
		return device_Id;
	}
	public void setDevice_Id(Integer device_Id) {
		this.device_Id = device_Id;
	}
	public Double getMeals() {
		return meals;
	}
	public void setMeals(Double meals) {
		this.meals = meals;
	}
	public Double getExercise() {
		return exercise;
	}
	public void setExercise(Double exercise) {
		this.exercise = exercise;
	}
	public Double getBasal() {
		return basal;
	}
	public void setBasal(Double basal) {
		this.basal = basal;
	}
	public Double getBolus() {
		return bolus;
	}
	public void setBolus(Double bolus) {
		this.bolus = bolus;
	}
	public Double getMeasurement() {
		return measurement;
	}
	public void setMeasurement(Double measurement) {
		this.measurement = measurement;
	} 
	
	
}
