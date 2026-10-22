package com.example.hotel_reservation_be.entity;


import com.example.hotel_reservation_be.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "reservation_guest")
public class ReservationGuest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id",nullable = false)
    private Reservation reservation;

    @Column(name = "first_name",nullable = false)
    private String firstName; 

    @Column(name = "last_name",nullable = false)
    private String lastName;

    private Integer age;

    @Column(name = "is_child",nullable = false)
    @Builder.Default
    private boolean child=false;

}
