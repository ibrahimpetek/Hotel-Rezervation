package com.example.hotel_reservation_be.entity;

import com.example.hotel_reservation_be.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "guest")
public class Guest extends BaseEntity {

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable =false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(name = "identity_number")
    private String identityNumber;

    private String nationality;
    
}
