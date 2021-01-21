package com.example.admin.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.entity.Beds;
import com.example.admin.entity.BedsAvailability;
import com.example.admin.entity.Rooms;
import com.example.admin.entity.RoomsAvailability;
import com.example.admin.repository.RoomsAvailabilityRepository;
import com.example.admin.repository.RoomsRepository;
import com.example.admin.service.AdminService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired	
	private RoomsRepository roomsRepository;
	
	@Autowired	
	private RoomsAvailabilityRepository roomsAvailabilityRepository;
	
	@GetMapping("/get_all/")
	public List<Rooms> showRooms() {
		List<Rooms> rooms = this.roomsRepository.findAll();
		return rooms;
	}
	
	// Insert a Room
	@PostMapping("/rooms_insert/")
	public Rooms saveRooms(@RequestBody Rooms rooms) {
		return adminService.saveRooms(rooms);
	}
	
	@DeleteMapping("/rooms_delete/{id}")
	public void deleteRooms(@PathVariable("id") Integer RoomId) {
		adminService.deleteRooms(RoomId);
	}
	
	@DeleteMapping("/bed_delete/{id}")
	public void deleteBeds(@PathVariable("id") Integer BedId) {
		adminService.deleteBeds(BedId);
	}
	
	@DeleteMapping("/rooms_avail_delete/{id}")
	public void deleteRoomsAvailability(@PathVariable("id") String RoomId) {
		String[] key = RoomId.split(",");
		String iden = key[0];
		String date = key[1];
		String time = key[2];

		adminService.deleteRoomsAvailability(iden,date,time);
	}
	
	@DeleteMapping("/beds_avail_delete/{id}")
	public void deleteBedsAvailability(@PathVariable("id") String BedId) {
		String[] key = BedId.split(",");
		String iden = key[0];
		String date = key[1];
		String time = key[2];

		adminService.deleteBedsAvailability(iden,date,time);
	}
	
	// Insert a Bed
	@PostMapping("/beds_insert/")
	public Beds saveBeds(@RequestBody Beds beds){
		return adminService.saveBeds(beds);
	}
	
	// Insert a Room Availability
	@PostMapping("/availability_insert/")
	public RoomsAvailability saveAvailability(@RequestBody RoomsAvailability roomsAvailability) {
		return adminService.saveAvailability(roomsAvailability);
	}
	
	// Insert a Bed Availability
	@PostMapping("/beds_avail_insert/")
	public BedsAvailability saveBedsAvailability(@RequestBody BedsAvailability bedsAvailability) {
		return adminService.saveBedsAvailability(bedsAvailability);
	}
	
	// Get a Room
	@GetMapping("/rooms_get/{id}")
	public Rooms getRooms(@PathVariable("id") Integer RoomID) {
		return adminService.findRoomsById(RoomID);
	}
	
	// Get a Bed
	@GetMapping("/bed_get/{id}")
	public Beds getBedByNumber(@PathVariable("id") Integer bedNumber){
		return adminService.findBedsByNumber(bedNumber);
	}
	
	// Get all Bed
	@GetMapping("/beds_get/{id}")
	public List<Beds> getBeds(@PathVariable("id") Integer RoomId){
		return adminService.findBedsByRoomId(RoomId);
	}
	
	// Get Availability
	@GetMapping("/availability_get/{id}")
	public List<RoomsAvailability> getAvailability(@PathVariable("id") Integer RoomID) {
		return adminService.findAvailabilityByRoomId(RoomID);
	}
	
	// Get Availability
	@GetMapping("/beds_avail_get/{id}")
	public List<BedsAvailability> getBedsAvailability(@PathVariable("id") Integer BedID) {
		return adminService.findAvailabilityByBedId(BedID);
	}
	
	// Update a Room
	@PutMapping("/rooms_update/{id}")
	public Rooms updateRooms(@PathVariable("id") Integer RoomID, @RequestBody Rooms roomDetails) {
		Rooms rooms = adminService.findRoomsById(RoomID);
		rooms.setFloorNumber(roomDetails.getFloorNumber());
		rooms.setRoomNumber(roomDetails.getRoomNumber());
		rooms.setRoomType(roomDetails.getRoomType());
		rooms.setCharges(roomDetails.getCharges());
		Rooms updatedRooms = adminService.saveRooms(rooms);
		return updatedRooms;
	}
	
	// Update a Bed
	@PutMapping("/beds_update/{id}")
	public Beds updateBeds(@PathVariable("id") Integer bedId, @RequestBody Beds bedDetails) {
		Beds beds = adminService.findBedsById(bedId);
		beds.setRoomId(bedDetails.getRoomId());
		beds.setBedNumber(bedDetails.getBedNumber());
		Beds updatedBeds = adminService.saveBeds(beds);
		return updatedBeds;
	}

	// Update an Availability
	@PutMapping("/beds_avail_update/{id}")
	public BedsAvailability updateBedsAvailability(@PathVariable("id") Integer BedID, @RequestBody BedsAvailability availabilityDetails) {
		
		List<BedsAvailability> availability = adminService.findAvailabilityByBedId(BedID);
		
		Iterator<BedsAvailability> iterator = (Iterator<BedsAvailability>) availability.iterator();
		
		BedsAvailability availability_details = new BedsAvailability();
		
		 while (iterator.hasNext()) {
			 BedsAvailability availability_temp = iterator.next();
		        if (availability_temp.getDate().equals(availabilityDetails.getDate()) && 
		        		availability_temp.getTime().equals(availabilityDetails.getTime())) {
		        	availability_details = availability_temp;
		        	break;
		        }
		    }
		
		availability_details.setAvailable(availabilityDetails.getAvailable()); 
		 
		BedsAvailability updatedAvailability = adminService.saveBedsAvailability(availability_details);
		return updatedAvailability;
	}
	
	// Update an Availability
	@PutMapping("/availability_update/{id}")
	public RoomsAvailability updateAvailability(@PathVariable("id") Integer RoomID, @RequestBody RoomsAvailability availabilityDetails) {
		
		List<RoomsAvailability> availability = adminService.findAvailabilityByRoomId(RoomID);
		
		Iterator<RoomsAvailability> iterator = (Iterator<RoomsAvailability>) availability.iterator();
		
		RoomsAvailability availability_details = new RoomsAvailability();
		
		 while (iterator.hasNext()) {
			 RoomsAvailability availability_temp = iterator.next();
		        if (availability_temp.getDate().equals(availabilityDetails.getDate()) && 
		        		availability_temp.getTime().equals(availabilityDetails.getTime())) {
		        	availability_details = availability_temp;
		        	break;
		        }
		    }
		
		availability_details.setAvailable(availabilityDetails.getAvailable()); 
		 
		RoomsAvailability updatedAvailability = adminService.saveAvailability(availability_details);
		return updatedAvailability;
	}
	
}
