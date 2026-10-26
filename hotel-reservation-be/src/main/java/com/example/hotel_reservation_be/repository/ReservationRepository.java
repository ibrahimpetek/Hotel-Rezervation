package com.example.hotel_reservation_be.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.Reservation;
import com.example.hotel_reservation_be.enums.ReservationStatus;

public interface ReservationRepository extends JpaRepository <Reservation,Long> {

    Optional<Reservation> findByReservationCode(String reservationCode);
    
    List<Reservation> findByLeadGuestEmailOrderByCreatedAtDesc(String email);

    List<Reservation> findByStatus(ReservationStatus status);

    /* Admin panelinde belirli tarih araliginda giris yapacak rezervasyonlari listelemek icin. */
    List<Reservation> findByCheckInBetweenOrderByCheckInAsc(LocalDate start, LocalDate end);

    List<Reservation> findByRoomTypeIdAndStatus(Long roomTypeId, ReservationStatus status);  
} 
