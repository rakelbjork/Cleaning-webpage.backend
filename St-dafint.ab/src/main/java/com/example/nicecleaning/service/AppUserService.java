package com.example.nicecleaning.service;

import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.repo.AppUserRepo;
import org.springframework.stereotype.Service;


@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUser findAppUserByEmail(String email){
        return appUserRepo.findAppUserByEmailIgnoreCase(email);
    }

    public void deleteById(int id) {
        appUserRepo.deleteById(id);
    }
}
