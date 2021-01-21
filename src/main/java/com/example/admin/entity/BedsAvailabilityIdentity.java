package com.example.admin.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

public class BedsAvailabilityIdentity implements Serializable {

	@Column(name = "bedId")
	private Integer bedId;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "time")
	private LocalTime time;

	public BedsAvailabilityIdentity() {
	}	
	
	public BedsAvailabilityIdentity(Integer bedId, LocalDate date, LocalTime time) {
		super();
		this.bedId = bedId;
		this.date = date;
		this.time = time;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedId == null) ? 0 : bedId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		BedsAvailabilityIdentity other = (BedsAvailabilityIdentity) obj;
		if (bedId == null) {
			if (other.bedId != null)
				return false;
		} else if (!bedId.equals(other.bedId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}	
	
}
