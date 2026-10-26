package com.example.hotel_reservation_be.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.hotel_reservation_be.common.BaseEntity;
import com.example.hotel_reservation_be.enums.PaymentStatus;

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
@Table(name ="payments")
public class Payment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id",nullable = false)
    private Reservation reservation;

    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal amount;

    @Column(name = "installment_count",nullable = false)
    @Builder.Default
    private Integer installmentCount=1;         //taksit seçenekleri

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private PaymentStatus status=PaymentStatus.PENDING;

    @Column(nullable = false)
    private String provider;

    @Column(name = "provider_payment_id")
    private String providerPaymentId;       //ödeme sonunda iyzico tarafından bize verilen

    @Column(name = "provider_conversation_id")
    private String providerConversationId;  //ödeme isteği gönderirken

    @Column(name = "paid_at")
    private LocalDateTime paidAt;   //ödeme onaylandı tarih saat

    @Column(name = "failure_reason",columnDefinition = "TEXT")
    private String failureReason;   //ödeme sırasında hata oluştu
    

}
