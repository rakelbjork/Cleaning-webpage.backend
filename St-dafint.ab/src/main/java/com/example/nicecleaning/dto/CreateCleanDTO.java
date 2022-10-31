package com.example.nicecleaning.dto;

public record CreateCleanDTO(
        String date,
        String time,
        String optionalMessage,
        int id) {

    public long appUserId() {
        return id;
    }
}
