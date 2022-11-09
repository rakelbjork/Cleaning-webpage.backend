package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.CleanResponseDTO;
import com.example.nicecleaning.dto.CreateBookingDTO;
import com.example.nicecleaning.entities.Booking;
import com.example.nicecleaning.services.CleanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clean")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class BookingController {

    private final CleanService cleanService;

    public BookingController(CleanService cleanService){
        this.cleanService = cleanService;
    }

    @PostMapping
    public CleanResponseDTO addClean(@RequestBody() CreateBookingDTO createBookingDTO){
        return cleanService
                .addClean(
                        createBookingDTO.date(),
                        createBookingDTO.time(),
                        createBookingDTO.optionalMessage(),
                        createBookingDTO.appUserId()
                )
                .toResponseDTO();
    }

    @GetMapping
    public List<CleanResponseDTO> findAll(
            @RequestParam(required = false, defaultValue = "", name = "tcon") String contains
    ){
        return cleanService.findAll(contains)
                .stream()
                .map(Booking::toResponseDTO)
                .toList();
    }


    public Booking cleanDuplicateCheck(String date, int id){
        return cleanService.cleanDuplicateCheck(date, id);
    }

    @PutMapping("/{id}")
    public void unscheduleClean(@PathVariable int id){
        System.out.println("Test");
        cleanService.unscheduleClean(id);
    }
}