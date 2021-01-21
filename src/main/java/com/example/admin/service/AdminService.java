package com.example.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.entity.Beds;
import com.example.admin.entity.BedsAvailability;
import com.example.admin.entity.Rooms;
import com.example.admin.entity.RoomsAvailability;
import com.example.admin.repository.BedsAvailabilityRepository;
import com.example.admin.repository.BedsRepository;
import com.example.admin.repository.RoomsAvailabilityRepository;
import com.example.admin.repository.RoomsRepository;

@Service
public class AdminService {

	@Autowired
	private RoomsRepository roomsRepository;
	
	@Autowired
	private BedsRepository bedsRepository;
	
	@Autowired
	private BedsAvailabilityRepository bedsAvailabilityRepository;
	
	@Autowired
	private RoomsAvailabilityRepository roomsAvailabilityRepository;
	
	public Rooms saveRooms(Rooms rooms) {
		return roomsRepository.save(new Rooms(rooms.getRoomId(), rooms.getRoomType(), 
				rooms.getRoomNumber(), rooms.getFloorNumber(), rooms.getCharges()));
	}

	public void deleteRooms(Integer roomId) {
		roomsRepository.deleteById(roomId);
	}
	
	public void deleteBeds(Integer bedId) {
		System.out.println("The Bed Id is : ");
		System.out.println(bedId);
		bedsRepository.deleteById(bedId);
	}
	
//	public void deleteBeds(Integer bedId) {
//		bedsRepository.deleteById(bedId);
//	}
	
	public Rooms findRoomsById(Integer roomID) {		
		return roomsRepository.findByRoomId(roomID);
	}
	
	public Beds findBedsById(Integer bedID) {		
		return bedsRepository.findByBedId(bedID);
	}

	public Beds saveBeds(Beds beds) {
		return bedsRepository.save(new Beds(beds.getBedId(),beds.getBedNumber(),beds.getRoomId()));
	}

	public void deleteRoomsAvailability(String iden, String date, String time) {
		roomsAvailabilityRepository.deleteByRoomsAvailability(iden,date,time);
	}

	public void deleteBedsAvailability(String iden, String date, String time) {
		bedsAvailabilityRepository.deleteByBedsAvailability(iden,date,time);
	}
	
	public Beds findBedsByNumber(Integer bedNumber) {
		return bedsRepository.findByBedNumber(bedNumber);
	}
	
	public List<Beds> findBedsByRoomId(Integer roomId) {
		return bedsRepository.findByRoomId(roomId);
	}

	public RoomsAvailability saveAvailability(RoomsAvailability roomsAvailability) {
		return roomsAvailabilityRepository.save(new RoomsAvailability(roomsAvailability.getRoomId(),roomsAvailability.getDate(),
				roomsAvailability.getTime(),roomsAvailability.getAvailable()));
	}
	
	public BedsAvailability saveBedsAvailability(BedsAvailability bedsAvailability) {
		return bedsAvailabilityRepository.save(new BedsAvailability(bedsAvailability.getBedId(),bedsAvailability.getDate(),
				bedsAvailability.getTime(),bedsAvailability.getAvailable()));
	}

	public List<RoomsAvailability> findAvailabilityByRoomId(Integer roomID) {
		return roomsAvailabilityRepository.findByRoomId(roomID);
	}
	
	public List<BedsAvailability> findAvailabilityByBedId(Integer bedID) {
		return bedsAvailabilityRepository.findByBedId(bedID);
	}

}
