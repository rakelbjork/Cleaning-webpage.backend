package com.example.nicecleaning.repo;


import com.example.nicecleaning.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update AppUser a " +
    "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    Optional<AppUser> findAppUserByEmailIgnoreCase(String email);

    AppUser findAppUserById(Long id);
}
