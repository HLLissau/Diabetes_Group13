package group13.model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Measurement")
@IdClass(MeasurementId.class)
public class Measurement {
	@Id
	@Column
	private Long userId;
	@Id
	@Column
	private  Timestamp time;
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
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long user_Id) {
		this.userId = user_Id;
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
