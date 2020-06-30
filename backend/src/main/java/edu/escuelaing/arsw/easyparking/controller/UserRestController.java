/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.easyparking.controller;

import edu.escuelaing.arsw.easyparking.dto.UserDTO;
import edu.escuelaing.arsw.easyparking.model.User;
import edu.escuelaing.arsw.easyparking.service.UserService;
import edu.escuelaing.arsw.easyparking.mapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vashi
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<UserDTO> getAllUsers() {
        return ObjectMapper.mapAll(userService.findAll(), UserDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        
        User user = userService.findByEmail(email);
        
        if (user==null) {
            return ResponseEntity.badRequest().body("Usuario no Existe");
        }else{
            return ResponseEntity.status(200).body(user);
        }
        
    }

    @GetMapping(value = "/orderByRol")
    public List<UserDTO> findAllByOrderByRol() {
        return ObjectMapper.mapAll(userService.findAllByOrderByRol(), UserDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody UserDTO userDTO) {
        User user = userService.saveOrUpdateUser(ObjectMapper.map(userDTO, User.class));
        
        if (user==null) {
            return ResponseEntity.badRequest().body("Error! Formato incorrecto");
        }else{
            return ResponseEntity.status(200).body(user);
        }
      
    }

    @DeleteMapping(value = "/delete/{userEmail}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable String userEmail) {
        userService.deleteUserById(userService.findByEmail(userEmail).getId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

}