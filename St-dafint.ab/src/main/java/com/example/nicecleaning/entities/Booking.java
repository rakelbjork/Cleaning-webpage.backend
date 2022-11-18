package com.example.nicecleaning.entities;

import com.example.nicecleaning.dto.BookingResponseDTO;

import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Varje städning får sitt egna unika ID
    private int id;

    @Column(nullable = false)
    // Städtidens bokade datum. Planen är att göra om denna till en LocalDate sen
    private String date;

    @Column(nullable = false)
    //Städtidens bokade tid. Planen är att göra om denna till en LocalTime sen
    private String time;

    @Column(nullable = false)
    // Visar vilken status som städningen har.
    // 0 är obekräftad, 1 är bekräftad, 2 är bokad
    // 3 är under utförande, 4 är utfört, 5 är godkänt
    // 6 är fakturerad, 7 är betald, 8 är avbokad
    private int status = 0;

    @Column
    // Ett id per städare. 0 betyder att ingen accepterat ditt pass
    private int cleanerId = 0;

    @Column
    // Ett valfritt meddelande till städaren
    private String optionalMessage;

    @ManyToOne
    // Vilken användare som bokade städningen
    private AppUser appUser;

    public Booking(String date, String time, String optionalMessage, int cleanerId, int status, AppUser appUser) {
        this.date = date;
        this.time = time;
        this.optionalMessage = optionalMessage;
        this.status = status;
        this.cleanerId = cleanerId;
        this.appUser = appUser;
    }

    public Booking(){

    }

    public BookingResponseDTO toResponseDTO() {
        return new BookingResponseDTO(id, date, time, optionalMessage, status, appUser.getId());
    }
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int whatIsStatus() {
        return status;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
