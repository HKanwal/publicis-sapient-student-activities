package com.sapient.dbexample.controller;

import com.sapient.dbexample.exceptions.NonexistentUserException;
import com.sapient.dbexample.model.beans.User_;
import com.sapient.dbexample.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User_ createUser(@RequestBody String name) {
        return userService.createUser(name);
    }

    @GetMapping("/users")
    public List<User_> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/user")
    public ResponseEntity<Object> fetchUser(@RequestBody int id) {
        try {
            User_ user = userService.fetchUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (NonexistentUserException e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<Object> modifyUser(@RequestBody int id, String name) {
        try {
            User_ user = userService.modifyUser(id, name);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (NonexistentUserException e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteUser(@RequestBody int id) {
        try {
            userService.deleteUser(id);
            Map<String, String> response = new HashMap<String, String>();
            response.put("success", "deleted user with id: "+id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (NonexistentUserException e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
