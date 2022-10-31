package com.example.nicecleaning.services;

import com.example.nicecleaning.entities.AppUser;

import com.example.nicecleaning.entities.Clean;
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

    public List<Clean> findAll(String contains) {
        return cleanRepo.findAll();
    }

    public Clean findById(int id){
        return cleanRepo.findById(id).orElseThrow();
    }

    public Clean addClean(String date, String time, String message, Long userId){
        AppUser appUser = appUserRepo.findById(userId).orElseThrow();
        return cleanRepo.save(new Clean(date, time, message, 0, 0, appUser));
    }

    public Clean cleanDuplicateCheck(String date, int id) {
        return cleanRepo.findCleanByDateAndId(date, id);
    }

    public void unscheduleClean(int id) {
        Clean clean = cleanRepo.getReferenceById(id);
        clean.setStatus(7);
        System.out.println("Hmm");
        cleanRepo.save(clean);

    }
}