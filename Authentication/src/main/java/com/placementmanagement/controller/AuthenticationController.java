package com.placementmanagement.controller;

////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.placementmanagement.auth.JwtUtil;
//import com.placementmanagement.entity.User;
//import com.placementmanagement.repo.UserRepository;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthenticationController {
//
//    private final JwtUtil jwtUtil;
//    private final UserRepository userRepository;
//
//   // @Autowired
//    public AuthenticationController(JwtUtil jwtUtil, UserRepository userRepository) {
//        this.jwtUtil = jwtUtil;
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User loginDto) {
//        User user = userRepository.findByUsername(loginDto.getName());
//        if (user != null && user.getPassword().equals(loginDto.getPassword())) {
//            String token = jwtUtil.generateToken(user.getName());
//            return ResponseEntity.ok(new AuthenticationResponse(token));
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User registerDto) {
//        // Register logic goes here, save user in DB
//        return ResponseEntity.ok("Registration successful");
//    }
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementmanagement.entity.User;
import com.placementmanagement.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getName(), user.getPassword());
        if (loggedInUser != null) {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}