package com.example.admin.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BedsAvailabilityIdentity.class)
@Table(name = "beds_availability")
public class BedsAvailability implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bedId")
	private Integer bedId;
	
	@Id
	@Column(name = "date")
	private LocalDate date;
	
	@Id
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "available")
	private Character available;

	public BedsAvailability() {
		
	}

	public BedsAvailability(Integer bedId, LocalDate date, LocalTime time, Character available) {
		super();
		this.bedId = bedId;
		this.date = date;
		this.time = time;
		this.available = available;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Character getAvailable() {
		return available;
	}

	public void setAvailable(Character available) {
		this.available = available;
	}	
	
}
