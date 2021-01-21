package com.example.admin.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
//@IdClass(BedsIdentity.class)
@Table(name = "beds")
public class Beds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bedId")
	private Integer bedId;
	
	@Column(name = "roomId")
	private Integer roomId;
	
	@Column(name = "bedNumber")
	private Integer bedNumber;

	public Beds() {
		
	}

	public Beds(Integer bedId, Integer bedNumber, Integer roomId) {
		super();
		this.bedId = bedId;
		this.roomId = roomId;
		this.bedNumber = bedNumber;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}
	
}
