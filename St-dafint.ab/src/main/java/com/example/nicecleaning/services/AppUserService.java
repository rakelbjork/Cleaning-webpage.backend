package com.example.nicecleaning.services;

import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.BookingRepo;
import org.springframework.stereotype.Service;


@Service


public class AppUserService {

    private final AppUserRepo appUserRepo;
    private final BookingRepo bookingRepo;


    public AppUserService(AppUserRepo appUserRepo, BookingRepo bookingRepo) {
        this.appUserRepo = appUserRepo;
        this.bookingRepo = bookingRepo;
    }





}
