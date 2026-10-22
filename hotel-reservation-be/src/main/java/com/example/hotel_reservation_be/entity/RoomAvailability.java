package com.example.hotel_reservation_be.entity;

import java.time.LocalDate;

import com.example.hotel_reservation_be.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor 
@NoArgsConstructor 
@Setter 
@Getter 
@Builder 
@Entity 
@Table(name = "room_availability",uniqueConstraints = @UniqueConstraint(columnNames ={"room_type_id","date"} ))
public class RoomAvailability extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id",nullable = false)
    private RoomType roomType;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "total_rooms",nullable = false)
    private Integer totalRooms;

    @Column(name = "booked_rooms",nullable = false)
    @Builder.Default
    private Integer bookedRooms=0;  //rezerve edilen oda sayısı

    @Transient                         //metodun sonucunun veritabanında bir sütun olarak saklanmayacağını
    public int getAvailableRooms(){
        return totalRooms-bookedRooms;
    }
    
}
