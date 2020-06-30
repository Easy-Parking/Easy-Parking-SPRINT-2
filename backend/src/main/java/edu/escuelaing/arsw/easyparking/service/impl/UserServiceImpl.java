/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.easyparking.service.impl;

import edu.escuelaing.arsw.easyparking.model.User;
import edu.escuelaing.arsw.easyparking.repository.UserRepository;
import edu.escuelaing.arsw.easyparking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vashi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllByOrderByRol() {
        return userRepository.findAllByOrderByRol();
    }

    @Override
    public User saveOrUpdateUser(User user) {        
        //sacar usuario si existe
        User userExist = userRepository.findByEmail(user.getEmail());
        //si existe actualizar valores
        if(userExist != null){
            String id = userExist.getId();
            user.setId(id);
            return userRepository.save(user);
        }else{
            return userRepository.save(user);
        }
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
    

}