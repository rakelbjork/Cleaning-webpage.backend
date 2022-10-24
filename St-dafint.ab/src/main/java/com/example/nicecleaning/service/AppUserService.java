package com.example.nicecleaning.service;

import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.entities.Role;
import com.example.nicecleaning.repo.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public List<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    public void deleteById(int id) {
        appUserRepo.deleteById(id);
    }
}
