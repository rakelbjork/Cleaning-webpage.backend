package com.example.nicecleaning.repo;

import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    Booking findBookingByDateAndId(String date, Long id);

    List<Booking> findBookingByAppUserAndStatus(AppUser appUser, int status);
}

