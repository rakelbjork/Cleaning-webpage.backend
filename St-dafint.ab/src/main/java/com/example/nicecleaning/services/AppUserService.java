package com.example.nicecleaning.services;

import com.example.nicecleaning.dto.CreateAppUserDTO;
import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.entities.Role;
import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service


public class AppUserService {

    private final AppUserRepo appUserRepo;
    private final BookingRepo bookingRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepo appUserRepo, BookingRepo bookingRepo) {
        this.appUserRepo = appUserRepo;
        this.bookingRepo = bookingRepo;
    }

    public void createUser(CreateAppUserDTO createAppUserDTO){
    appUserRepo.save(
            new AppUser(createAppUserDTO.firstname(),
                    createAppUserDTO.lastname(),
                    createAppUserDTO.adress(),
                    createAppUserDTO.phonenumber(),
                    createAppUserDTO.username(),
                    passwordEncoder.encode(createAppUserDTO.password()),
                    Set.of(Role.USER))
    );
}


}
