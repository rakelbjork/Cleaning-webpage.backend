package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.BookingResponseDTO;
import com.example.nicecleaning.dto.CreateBookingDTO;
import com.example.nicecleaning.entities.Booking;
import com.example.nicecleaning.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clean")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDTO addClean(@RequestBody() CreateBookingDTO createBookingDTO){
        return bookingService
                .addClean(
                        createBookingDTO.date(),
                        createBookingDTO.time(),
                        createBookingDTO.optionalMessage(),
                        createBookingDTO.appUserId()
                )
                .toResponseDTO();
    }

    @GetMapping
    public List<BookingResponseDTO> findAll(
            @RequestParam(required = false, defaultValue = "", name = "tcon") String contains
    ){
        return bookingService.findAll(contains)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }
    @GetMapping("/{id}/finished")
    public List<BookingResponseDTO> findFinished(@PathVariable Long id){
        return bookingService.findSpecificList(id, 7)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}/unbooked")
    public List<BookingResponseDTO> findUnbooked(@PathVariable Long id){
        return bookingService.findSpecificList(id, 8)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}/accepted")
    public List<BookingResponseDTO> findAccepted(@PathVariable Long id){
        return bookingService.findSpecificList(id, 5)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }


    public Booking cleanDuplicateCheck(String date, Long id){
        return bookingService.cleanDuplicateCheck(date, id);
    }

    @PutMapping("/{id}")
    public void unscheduleClean(@PathVariable Long id){
        System.out.println("Test");
        bookingService.unscheduleClean(id);
    }
}