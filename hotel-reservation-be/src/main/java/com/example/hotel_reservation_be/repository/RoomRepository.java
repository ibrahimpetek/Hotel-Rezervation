package com.example.hotel_reservation_be.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.Room;
import com.example.hotel_reservation_be.enums.RoomStatus;

public interface RoomRepository extends JpaRepository <Room,Long> {

    List<Room> findByRoomTypeId(Long roomTypeId); 

    Optional<Room> findByRoomNumber(String roomNumber);

    List<Room> findByRoomTypeIdAndStatus(Long roomTypeId, RoomStatus status);
} 