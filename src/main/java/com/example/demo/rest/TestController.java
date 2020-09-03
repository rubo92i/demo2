package com.example.demo.rest;


import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@CustomController("/user")
public class TestController {


    @Autowired
    private UserRepository userRepository;


    @CustomRequestMapping("/getByUsername")
    public ResponseEntity getUsers(String username) {
        return ResponseEntity.ok(userRepository.getByUsername(username));
    }


    @CustomRequestMapping("/getById")
    public ResponseEntity getUsers(int id) {
        return ResponseEntity.ok(userRepository.getById(id));
    }


}
