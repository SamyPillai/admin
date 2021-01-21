package com.example.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.BedsAvailability;
import com.example.admin.entity.BedsAvailabilityIdentity;

@Repository
public interface BedsAvailabilityRepository extends JpaRepository<BedsAvailability,BedsAvailabilityIdentity>{

	List<BedsAvailability> findByBedId(Integer bedID);

	@Transactional    
	@Modifying
	@Query(value="DELETE FROM beds_availability WHERE bed_id=?1 and date=?2 and time=?3", nativeQuery = true)
	void deleteByBedsAvailability(String roomId,String date,String time);
	
}
