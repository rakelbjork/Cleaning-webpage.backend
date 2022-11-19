package com.example.nicecleaning.dto;

public record CreateAppUserDTO(

        String firstname,
        String lastname,
        String adress,
        String phonenumber,
        String username,
        String password) {

}
