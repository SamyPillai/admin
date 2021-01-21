package com.example.admin.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RoomsAvailabilityIdentity.class)
@Table(name = "rooms_availability")
public class RoomsAvailability implements Serializable{

	@Id
	@Column(name = "roomId")
	private Integer roomId;
	
	@Id
	@Column(name = "date")
	private LocalDate date;
	
	@Id
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "available")
	private Character available;

	public RoomsAvailability() {
		
	}

	public RoomsAvailability(Integer roomId, LocalDate date, LocalTime time, Character available) {
		super();
		this.roomId = roomId;
		this.date = date;
		this.time = time;
		this.available = available;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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
