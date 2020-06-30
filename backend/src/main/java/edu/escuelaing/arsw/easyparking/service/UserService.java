/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.easyparking.service;

import edu.escuelaing.arsw.easyparking.model.User;

import java.util.List;

/**
 * @author vashi
 */
public interface UserService {

    List<User> findAll();
    
    User findByEmail(String email);

    List<User> findAllByOrderByRol();

    User saveOrUpdateUser(User student);

    void deleteUserById(String id);

}
