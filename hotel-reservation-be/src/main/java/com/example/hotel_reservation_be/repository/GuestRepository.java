package com.example.hotel_reservation_be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.Guest;


public interface GuestRepository extends JpaRepository <Guest,Long> {

    /*email benzersiz olduğu için  */
    Optional <Guest> findByEmail(String email);
  
} 
