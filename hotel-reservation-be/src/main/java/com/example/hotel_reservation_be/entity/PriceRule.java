package com.example.hotel_reservation_be.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.hotel_reservation_be.common.BaseEntity;
import com.example.hotel_reservation_be.enums.BoardType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "price_rule")
public class PriceRule extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id",nullable = false)
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_type",nullable = false)
    private BoardType boardType;

    @Column(name = "start_date",nullable = false)
    private LocalDate starDate;

    @Column(name = "end_date",nullable = false)
    private LocalDate endDate;

    @Column(name = "adult_price",nullable = false,precision = 10,scale = 2)
    private BigDecimal adultPrice;

    @Column(name = "child_price",precision = 10,scale = 2)
    @Builder.Default
    private BigDecimal childPrice=BigDecimal.ZERO;

    @Column(name = "infant_price",precision = 10,scale = 2)
    @Builder.Default
    private BigDecimal infantPrice=BigDecimal.ZERO;

    @Column(nullable = false)
    @Builder.Default
    private boolean active=true;   
    
}
