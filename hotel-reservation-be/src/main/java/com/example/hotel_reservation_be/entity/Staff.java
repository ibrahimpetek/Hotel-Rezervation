package com.example.hotel_reservation_be.entity;

import com.example.hotel_reservation_be.common.BaseEntity;
import com.example.hotel_reservation_be.enums.StaffRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "staff")
public class Staff extends BaseEntity {

    @Column(nullable = false,unique = true) //benzersiz
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StaffRole role;

    @Column(nullable = false)
    @Builder.Default
    private boolean active=true;
}
