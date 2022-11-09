package com.example.nicecleaning;

import com.example.nicecleaning.repo.AppUserRepo;
import com.example.nicecleaning.repo.CleanRepo;
import com.example.nicecleaning.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CleanRepo cleanRepo;
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
          //  appUserRepo.save(new AppUser("Johan", "Forsberg", "johan.forsberg@my.com", passwordEncoder.encode("1234"), AppUserRole.USER));

        }catch (DataIntegrityViolationException err )  {
            System.out.println(err.getMessage());
        }

    }

}
