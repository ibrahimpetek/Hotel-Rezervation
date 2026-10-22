package com.example.hotel_reservation_be.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.hotel_reservation_be.common.BaseEntity;
import com.example.hotel_reservation_be.enums.BoardType;
import com.example.hotel_reservation_be.enums.ReservationStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "reservations")
public class Reservation extends BaseEntity {


    @Column(name = "reservation_code",nullable = false,unique = true)
    private String reservationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_guest_id",nullable = false)
    private Guest leadGuest;        //rezervasyonda iletişim kuran

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id",nullable = false)
    private RoomType roomType;

    @Column(name = "check_in",nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out",nullable = false)
    private LocalDate checkOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_type",nullable = false)
    private BoardType boardType;

    @Column(name = "adult_count",nullable = false)
    private Integer adultCount;

    @Column(name = "child_count",nullable = false)
    @Builder.Default
    private Integer childCount=0;

    @Column(name = "total_price",nullable = false,precision = 10,scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ReservationStatus status= ReservationStatus.PENDING_PAYMENT;

    @Column(name = "special_requests",columnDefinition = "TEXT")
    private String specialRequests;

    @OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL,orphanRemoval =true,fetch = FetchType.LAZY )
    @Builder.Default
    private List<ReservationGuest> guest =new ArrayList<>();

    @OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @Builder.Default
    private List<Payment> payments =new ArrayList<>();
  
}
