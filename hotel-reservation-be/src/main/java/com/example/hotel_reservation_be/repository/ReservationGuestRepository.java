package com.example.hotel_reservation_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.ReservationGuest;

public interface ReservationGuestRepository extends JpaRepository <ReservationGuest,Long> {

    /* Belirli bir rezervasyon kaydına ait olan tüm ek misafirlerin (oda sakinlerinin) listesini tek sorguda çekmek için tam yerinde bir metot. */
    List<ReservationGuest> findByReservationId(Long reservationId);
} 
