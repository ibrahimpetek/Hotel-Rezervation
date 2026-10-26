package com.example.hotel_reservation_be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long> {

    Optional <Staff> findByEmail(String email);

    boolean existsByEmail(String email);
   
} 
