package com.example.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.RoomsAvailability;
import com.example.admin.entity.RoomsAvailabilityIdentity;

@Repository
public interface RoomsAvailabilityRepository extends JpaRepository<RoomsAvailability, RoomsAvailabilityIdentity> {

	List<RoomsAvailability> findByRoomId(Integer roomID);

	@Transactional    
	@Modifying
	@Query(value="DELETE FROM rooms_availability WHERE room_id=?1 and date=?2 and time=?3", nativeQuery = true)
	void deleteByRoomsAvailability(String roomId,String date,String time);
}
