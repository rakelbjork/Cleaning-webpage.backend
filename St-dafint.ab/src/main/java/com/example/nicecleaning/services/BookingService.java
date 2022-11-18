package com.example.nicecleaning.services;

import com.example.nicecleaning.entities.AppUser;

import com.example.nicecleaning.entities.Booking;
import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    private final AppUserRepo appUserRepo;


    public BookingService(BookingRepo bookingRepo, AppUserRepo appUserRepo) {
        this.bookingRepo = bookingRepo;
        this.appUserRepo = appUserRepo;
    }

    public List<Booking> findAll(String contains) {
        return bookingRepo.findAll();
    }

    public Booking findById(int id){
        return bookingRepo.findById(id).orElseThrow();
    }
// Lägger till en ny tvätt-tid
    public Booking addClean(String date, String time, String message, int userId){
        AppUser appUser = appUserRepo.findById(userId).orElseThrow();
        return bookingRepo.save(new Booking(date, time, message, 0, 0, appUser));
    }

    public Booking cleanDuplicateCheck(String date, int id) {
        return bookingRepo.findBookingByDateAndId(date, id);
    }

    // Hämtar användaren baserat på dess ID
    public void unscheduleClean(int id) {
        Booking booking = findById(id);
        booking.setStatus(8);
        bookingRepo.save(booking);
    }
    public List<Booking> findSpecificList(int id, int status) {
        AppUser appUser = appUserRepo.findAppUserById(id);
        return bookingRepo.findBookingByAppUserAndStatus(appUser, status);
    }
}