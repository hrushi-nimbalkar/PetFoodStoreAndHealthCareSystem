package com.spring.pet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="AppointmentId")
	private int appointmentId;
	 
	

	
	
	@Column(name = "petOwnerName")
	private String petOwnerName;
	
	@Column(name = "petOwnerEmail")
	private String petOwnerEmail;
	
	@Column(name = "petOwnerPhone")
	private long petOwnerPhone;
	
	@Column(name = "petType")
	private String petType;
	
	@Column(name = "petBreed")
	private String petBreed;
	
	@Column(name = "petAge")
	private String petAge;
	
	@Column(name = "petProblemSummary")
	private String petProblemSummary;
	
	@Column(name = "chooseDate")
	private String chooseDate;
	
	
	/*
	 * @Column(name = "chooseTime") private String time;
	 */
	 
	
	
	

	public int getAppointmentId() {
		return appointmentId;
	}

	public String getPetOwnerName() {
		return petOwnerName;
	}

	public void setPetOwnerName(String petOwnerName) {
		this.petOwnerName = petOwnerName;
	}

	public String getPetOwnerEmail() {
		return petOwnerEmail;
	}

	public void setPetOwnerEmail(String petOwnerEmail) {
		this.petOwnerEmail = petOwnerEmail;
	}

	public long getPetOwnerPhone() {
		return petOwnerPhone;
	}

	public void setPetOwnerPhone(long petOwnerPhone) {
		this.petOwnerPhone = petOwnerPhone;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public String getPetAge() {
		return petAge;
	}

	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}

	public String getPetProblemSummary() {
		return petProblemSummary;
	}

	public void setPetProblemSummary(String petProblemSummary) {
		this.petProblemSummary = petProblemSummary;
	}

	public String getChooseDate() {
		return chooseDate;
	}

	public void setChooseDate(String chooseDate) {
		this.chooseDate = chooseDate;
	}

	


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", petOwnerName=" + petOwnerName + ", petOwnerEmail="
				+ petOwnerEmail + ", petOwnerPhone=" + petOwnerPhone + ", petType=" + petType + ", petBreed=" + petBreed
				+ ", petAge=" + petAge + ", petProblemSummary=" + petProblemSummary + ", chooseDate=" + chooseDate
				+ "]";
	}

	
	
		
}
