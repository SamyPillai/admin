package com.example.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.Beds;
import com.example.admin.entity.BedsIdentity;

@Repository
public interface BedsRepository extends JpaRepository<Beds,Integer> {

	Beds findByBedNumber(Integer bedNumber);
	List<Beds> findByRoomId(Integer roomId);
	void deleteById(Integer bedId);
	Beds findByBedId(Integer bedID);

}
