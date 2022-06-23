package com.sapient.lesson.controller;

import com.sapient.lesson.model.beans.User;
import com.sapient.lesson.model.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String greeting() {
        return "Hello World!";
    }

    @PostMapping("/hello")
    public Map<String, String> getData() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Hello", "World");
        return myMap;
    }

    @DeleteMapping("/hello")
    public String nope() {
        return "No.";
    }

    @PutMapping("/hello")
    public String refused() {
        return "Fine...";
    }

    // The returned bean will be parsed into JSON
    @GetMapping("/bean-example")
    public User getUser() {
        User user = new User();
        user.setName("Hark");
        user.setUserId(1234);
        user.setDob(LocalDate.parse("2000-05-01"));
        return user;
    }

    // 3 ways of passing input from client to webservice:
    // (1) request body, (2) request path, (3) request params
    @PostMapping("/user")
    public User bodyStore(@RequestBody User user) { // (1)
        return userService.createUser(user.getName(), user.getDob());
    }

    @PostMapping("/user/{name}") // (2)
    public User pathStore(@PathVariable("name") String name) {
        return userService.createUser(name, null);
    }

    @PostMapping("/user/params")
    public User paramStore(@RequestParam("name") String name) {
        return userService.createUser(name, null);
    }

    @GetMapping("/user")
    public User[] fetchUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/custom-status")
    public ResponseEntity<Object> get404() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No comprendo amigo.");
    }

    @GetMapping("/activity/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/activity/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestParam("dob") String dob) {
        return userService.updateUser(userId, LocalDate.parse(dob));
    }

    @DeleteMapping("/activity/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return "Mama mia.";
    }
}
