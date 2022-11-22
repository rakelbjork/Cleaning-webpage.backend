package com.example.nicecleaning;

import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.entities.Role;
import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.BookingRepo;
import com.example.nicecleaning.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    AppUserService appUserService;
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            appUserRepo.save(new AppUser("Roger", "rgoz", "betrhu", "4528783", "Roger", passwordEncoder.encode( "123"), Set.of(Role.USER)));
            AppUser appUser = appUserRepo.save(new AppUser("Admin", "VON", "adminsgatan", "1331", "admin", passwordEncoder.encode( "123"), Set.of(Role.ADMIN)));

            System.out.println(appUser.getPassword());
        }catch (DataIntegrityViolationException err )  {
            System.out.println(err.getMessage());
        }
    }

}
