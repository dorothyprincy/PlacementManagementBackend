package com.placementmanagement.controller;

//package com.tns.Admin;

import java.util.*; 
import org.springframework.beans.factory.annotation.*; 
import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;

import com.placementmanagement.entity.Admin;
import com.placementmanagement.service.AdminService; 

@RestController
public class AdminController {
	@Autowired
    private AdminService service;
	@GetMapping("/admin") 
    public List<Admin> list()  
    { 
        return service.listAll(); 
    } 
    @GetMapping("/admin/{id}") 
    public ResponseEntity<Admin> get(@PathVariable Integer id)  
    { 
        try  
        { 
            Admin admin = service.get(id); 
            return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
        }  
        catch (NoSuchElementException e)  
        { 
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND); 
        }       
    } 
    // RESTful API method for Create operation 
    @PostMapping("/admin") 
    public void add(@RequestBody Admin admin)  
    { 
        service.save(admin); 
    } 
      
    // RESTful API method for Update operation 
    @PutMapping("/admin/{id}") 
    public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id)  
    { 
        try  
        { 
            Admin existAdmin = service.get(id); 
            service.save(admin); 
            return new ResponseEntity<>(HttpStatus.OK); 
        }  
        catch (NoSuchElementException e)  
        { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }       
    } 
    // RESTful API method for Delete operation 
    @DeleteMapping("/admin/{id}") 
    public void delete(@PathVariable Integer id)  
    { 
        service.delete(id); 
    } 
}
