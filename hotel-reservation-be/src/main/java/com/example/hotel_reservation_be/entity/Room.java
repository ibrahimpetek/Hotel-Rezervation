package com.example.hotel_reservation_be.entity;

import com.example.hotel_reservation_be.common.BaseEntity;
import com.example.hotel_reservation_be.enums.RoomStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
//(oda numarası) sütununa benzersizlik kısıtlaması ekler.
@Table(name = "rooms",uniqueConstraints = @UniqueConstraint(columnNames = "room_number"))
public class Room extends BaseEntity{

    @Column(name = "room_number",nullable = false)
    private String roomNumber;

    private Integer floor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private RoomStatus status=RoomStatus.AVAILABLE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room-type_id",nullable = false)
    private RoomType RoomType;
   
}
