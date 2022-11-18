package com.example.nicecleaning.dto;

public record AppUserResponseDTO(
        // Allt om användarna. Exklusive lösenord, då det är "skyddat"
        int id,
        String username,
        java.util.Set<com.example.nicecleaning.entities.Role> role) {
}
