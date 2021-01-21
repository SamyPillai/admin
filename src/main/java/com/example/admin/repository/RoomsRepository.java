package com.example.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

	Rooms findByRoomId(Integer roomID);

}
