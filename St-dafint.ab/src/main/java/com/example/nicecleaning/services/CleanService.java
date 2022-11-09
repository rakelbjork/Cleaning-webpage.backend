package com.example.nicecleaning.services;

import com.example.nicecleaning.entities.AppUser;

import com.example.nicecleaning.entities.Booking;
import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.CleanRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanService {
    private final CleanRepo cleanRepo;
    private final AppUserRepo appUserRepo;


    public CleanService(CleanRepo cleanRepo, AppUserRepo appUserRepo) {
        this.cleanRepo = cleanRepo;
        this.appUserRepo = appUserRepo;
    }

    public List<Booking> findAll(String contains) {
        return cleanRepo.findAll();
    }

    public Booking findById(int id){
        return cleanRepo.findById(id).orElseThrow();
    }
// Lägger till en ny tvätt-tid
    public Booking addClean(String date, String time, String message, Long userId){
        AppUser appUser = appUserRepo.findById(userId).orElseThrow();
        return cleanRepo.save(new Booking(date, time, message, 0, 0, appUser));
    }

    public Booking cleanDuplicateCheck(String date, int id) {
        return cleanRepo.findCleanByDateAndId(date, id);
    }

    // Hämtar användaren baserat på dess ID
    public void unscheduleClean(int id) {
        Booking booking = cleanRepo.getReferenceById(id);
        booking.setStatus(7);
        System.out.println("Hmm");
        cleanRepo.save(booking);

    }
}