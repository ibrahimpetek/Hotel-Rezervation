package com.example.hotel_reservation_be.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hotel_reservation_be.entity.RoomAvailability;

import jakarta.persistence.LockModeType;

public interface RoomAvailabilityRepository extends JpaRepository <RoomAvailability,Long> {

     Optional<RoomAvailability> findByRoomTypeIdAndDate(Long roomTypeId, LocalDate date);

      /**
     * checkIn (dahil) - checkOut (haric) araligindaki tum gunlerin kayitlarini getirir.
     * Rezervasyon olusturmadan once her gun icin availableRooms > 0 kontrolu
     * bu listeyle yapilir.
     */

       @Query("""
            select ra from RoomAvailability ra
            where ra.roomType.id = :roomTypeId
              and ra.date >= :checkIn
              and ra.date < :checkOut
            order by ra.date
            """)
    List<RoomAvailability> findRangeForRoomType(
            @Param("roomTypeId") Long roomTypeId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );

     /**
     * Rezervasyon onayi sirasinda ayni anda gelen isteklerde "overbooking"
     * olmamasi icin pessimistic lock ile satiri kilitleyerek okur.
     * Servis katmaninda stok dusurme (bookedRooms++) bu metodla alinan
     * entity uzerinde yapilmalidir.
     */

     @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            select ra from RoomAvailability ra
            where ra.roomType.id = :roomTypeId and ra.date = :date
            """)
    Optional<RoomAvailability> findByRoomTypeIdAndDateForUpdate(
            @Param("roomTypeId") Long roomTypeId,
            @Param("date") LocalDate date
    );
    
} 
