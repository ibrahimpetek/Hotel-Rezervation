package com.example.hotel_reservation_be.enums;


//Konsept tipi her biri farklı fiyata sahip
public enum BoardType {

    ROOM_ONLY("Sadece Oda"),
    BAD_AND_BREAKFAST("Kahvaltı Dahil"),
    HALF_BOARD("Yarım Pansiyon"),
    FULL_BOARD("Tam Pansiyon"),
    ULTRA_ALL_INCLUSIVE("Ultra Herşey Dahil");
    

    private final String displayName;

    BoardType(String displayName){
        this.displayName=displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    
}
