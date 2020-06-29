/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.easyparking.controller;

import edu.escuelaing.arsw.easyparking.model.User;
import edu.escuelaing.arsw.easyparking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/orderByRol")
    public List<User> findAllByOrderByRol() {
        return userService.findAllByOrderByRol();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody User student) {
        userService.saveOrUpdateStudent(student);
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentEmail}")
    public ResponseEntity<?> deleteStudentByStudentEmail(@PathVariable String userEmail) {
        userService.deleteUserById(userService.findByEmail(userEmail).getId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }
    
}