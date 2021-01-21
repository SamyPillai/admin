package com.example.admin.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class BedsIdentity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bedId")
	private Integer bedId;
	
    @Column(name = "roomId")
	private Integer roomId;
	
    @Column(name = "bedNumber")
    private Integer bedNumber;

	public BedsIdentity() {
		
	}

	public BedsIdentity(Integer bedId, Integer roomId, Integer bedNumber) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedId == null) ? 0 : bedId.hashCode());
		result = prime * result + ((bedNumber == null) ? 0 : bedNumber.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BedsIdentity other = (BedsIdentity) obj;
		if (bedId == null) {
			if (other.bedId != null)
				return false;
		} else if (!bedId.equals(other.bedId))
			return false;
		if (bedNumber == null) {
			if (other.bedNumber != null)
				return false;
		} else if (!bedNumber.equals(other.bedNumber))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		return true;
	}
	
}
