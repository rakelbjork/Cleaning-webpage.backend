package com.example.nicecleaning.dto;

public record BookingResponseDTO(
        // ID på städningen
        Long id,
        // Datum och tid på städningen
        String date,
        String time,
        // Valfria meddelandet
        String optionalMessage,
        // Statusen på den. Bekräftad, obekräftad, osv.
        int status,
        // Vem som bokade den. Ska bytas ut mot vem städaren är i slutändan
        Long appUserId) {

}