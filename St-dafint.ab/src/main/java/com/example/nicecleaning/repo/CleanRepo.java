package com.example.nicecleaning.repo;

import com.example.nicecleaning.entities.Clean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanRepo extends JpaRepository<Clean, Integer> {

    Clean findCleanByDateAndId(String date, int id);
}

