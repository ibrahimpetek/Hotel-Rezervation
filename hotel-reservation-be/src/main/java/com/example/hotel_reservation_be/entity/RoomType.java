package com.example.hotel_reservation_be.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import com.example.hotel_reservation_be.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
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
@Table(name = "room_types")
public class RoomType extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "size_m2")
    private Integer sizeM2;

    @Column(name = "max_adult",nullable = false)
    private Integer maxAdult;

    @Column(name = "max_child",nullable = false)
    @Builder.Default
    private Integer maxChild=0;

    @Column(name = "base_price",nullable = false,precision = 10,scale = 2)
    private BigDecimal basePrice;

    //Bu oda tipinde birden fazla fotoğraf linki tutacağım
    @ElementCollection 
    @CollectionTable(name = "room_type_images",joinColumns = @JoinColumn(name="room_type_id"))
    @Column(name = "image_url",length = 500)
    @OrderColumn(name = "sort_order") //fotoğraflar hangi sıra ile görünecek
    @Builder.Default
    private List<String> images =new ArrayList<>();

    @ElementCollection 
    @CollectionTable(name = "room_type_amenities",joinColumns = @JoinColumn(name="room_type_id") )
    @Column(name = "amenity")
    @Builder.Default
    private List<String>amenities=new ArrayList<>();

    //cascade ile başlayan oda tipi silinirse sisteme bağlı o fiziksel odalarda silinsin
    @OneToMany(mappedBy = "room_type",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @Builder.Default
    private List<Room> rooms=new ArrayList<>();

    @Column(nullable=false)
    @Builder.Default
    private boolean active =true;

}
