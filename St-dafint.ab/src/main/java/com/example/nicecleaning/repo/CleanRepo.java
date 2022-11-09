package com.example.nicecleaning.repo;

import com.example.nicecleaning.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanRepo extends JpaRepository<Booking, Integer> {

    Booking findCleanByDateAndId(String date, int id);
}

