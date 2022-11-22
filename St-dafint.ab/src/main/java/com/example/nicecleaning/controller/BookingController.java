package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.BookingResponseDTO;
import com.example.nicecleaning.dto.CreateBookingDTO;
import com.example.nicecleaning.entities.Booking;
import com.example.nicecleaning.services.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDTO addClean(@RequestBody() CreateBookingDTO createBookingDTO){
        System.out.println(createBookingDTO.date());
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
    public List<BookingResponseDTO> findFinished(@PathVariable int id){
        return bookingService.findSpecificList(id, 7)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}/unbooked")
    public List<BookingResponseDTO> findUnbooked(@PathVariable int id){
        return bookingService.findSpecificList(id, 8)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}/accepted")
    public List<BookingResponseDTO> findAccepted(@PathVariable int id){
        return bookingService.findSpecificList(id, 5)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }


    @PutMapping("/{id}")
    public void unscheduleClean(@PathVariable int id){
        System.out.println("Test");
        bookingService.unscheduleClean(id);
    }
}