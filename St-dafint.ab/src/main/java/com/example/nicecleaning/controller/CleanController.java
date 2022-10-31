package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.CleanResponseDTO;
import com.example.nicecleaning.dto.CreateCleanDTO;
import com.example.nicecleaning.entities.Clean;
import com.example.nicecleaning.services.CleanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clean")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class CleanController {

    private final CleanService cleanService;

    public CleanController(CleanService cleanService){
        this.cleanService = cleanService;
    }

    @PostMapping
    public CleanResponseDTO addClean(@RequestBody() CreateCleanDTO createCleanDTO){
        return cleanService
                .addClean(
                        createCleanDTO.date(),
                        createCleanDTO.time(),
                        createCleanDTO.optionalMessage(),
                        createCleanDTO.appUserId()
                )
                .toResponseDTO();
    }

    @GetMapping
    public List<CleanResponseDTO> findAll(
            @RequestParam(required = false, defaultValue = "", name = "tcon") String contains
    ){
        return cleanService.findAll(contains)
                .stream()
                .map(Clean::toResponseDTO)
                .toList();
    }


    public Clean cleanDuplicateCheck(String date, int id){
        return cleanService.cleanDuplicateCheck(date, id);
    }

    @PutMapping("/{id}")
    public void unscheduleClean(@PathVariable int id){
        System.out.println("Test");
        cleanService.unscheduleClean(id);
    }
}