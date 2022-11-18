package com.example.nicecleaning.dto;

public record CreateAppUserDTO(
        String username,
        String firstname,
        String lastname,
        String adress,
        String phonenumber,
        String password) {

}
