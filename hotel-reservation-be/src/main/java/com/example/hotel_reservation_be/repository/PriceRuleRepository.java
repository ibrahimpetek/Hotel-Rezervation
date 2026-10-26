package com.example.hotel_reservation_be.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hotel_reservation_be.entity.PriceRule;
import com.example.hotel_reservation_be.enums.BoardType;

public interface PriceRuleRepository extends JpaRepository<PriceRule,Long> {

     /**
     * Belirli bir oda tipi + pansiyon tipi icin, verilen tarihi kapsayan
     * aktif fiyat kuralini bulur. Fiyat hesaplama servisinde konaklamanin
     * her gecesi icin ayri ayri cagrilir (sezon gecisleri farkli fiyat verebilir).
     */

     @Query("""
            select pr from PriceRule pr
            where pr.roomType.id = :roomTypeId
              and pr.boardType = :boardType
              and pr.active = true
              and pr.deleted = false
              and :date between pr.startDate and pr.endDate
            """)
    Optional<PriceRule> findActiveRuleForDate(
            @Param("roomTypeId") Long roomTypeId,
            @Param("boardType") BoardType boardType,
            @Param("date") LocalDate date
    );

   // oda tipinin ve pansiyon türünün tüm fiyat kurallarını (sezonlarını) liste olarak getirmek için.
    List<PriceRule> findByRoomTypeIdAndBoardType(Long roomTypeId, BoardType boardType);
 
    // Sadece oda tipine ait tüm fiyat kurallarını listelemek
    List<PriceRule> findByRoomTypeId(Long roomTypeId);

    
}
