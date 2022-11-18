package com.example.nicecleaning.dto;

public record CreateBookingDTO(
        String date,
        String time,
        String optionalMessage,
        int id) {

    public int appUserId() {
        return id;
    }
}
