package com.example.hotel_reservation_be.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_reservation_be.entity.Payment;
import com.example.hotel_reservation_be.enums.PaymentStatus;

public interface PaymentRepository extends JpaRepository <Payment,Long> {

    List<Payment> findByReservationId(Long reservationId);

    /*İyzico'dan ödeme sonucu (callback / webhook) döndüğünde, gelen veriyi veritabanındaki doğru ödeme kaydıyla eşleştirmek için  */
    Optional<Payment> findByProviderPaymentId(String providerPaymentId);

    /*Dış ödeme sağlayıcısından (örn. İyzico) gelen yanıtı, bizim veritabanındaki doğru ödeme kaydıyla eşleştirmek için kullanılır. */
    Optional<Payment> findByProviderConversationId(String providerConversationId);

    /*Bekleyen (PENDING), başarılı veya başarısız ödemeleri durumlarına göre filtrelemeyi sağlar. */
    List<Payment> findByStatus(PaymentStatus status);  
} 