package com.placementmanagement.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.placementmanagement.entity.College;
import com.placementmanagement.service.CollegeService;

import java.util.*;


@RestController
public class CollegeController {

    @Autowired
    private CollegeService service;

    @GetMapping("/college")
    public List<College> searchall(){
        return service.searchAll();
    }


    @GetMapping("/college/{id}")
    public ResponseEntity<College> searchCollege(@PathVariable Long id){
        try {
            College college=service.get(id);
            return new ResponseEntity<College>(college, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/college")
    public void addCollege(@RequestBody College college){
        service.save(college);
    }


    @PutMapping("/college/{id}")
    public ResponseEntity<?> updateCollege(@RequestBody College college, @PathVariable Long id) {
        try {
            College existCollege = service.get(id);
            service.save(college);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/college/{id}")
    public void deleteCollege(@PathVariable Long id){
        service.delete(id);
    }
}
