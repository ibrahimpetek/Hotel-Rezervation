package com.example.hotel_reservation_be.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {

    Optional<RoomType> findByNameIgnoreCase(String name);

    List<RoomType> findByActiveTrueAndDeletedFalse();
   
}
