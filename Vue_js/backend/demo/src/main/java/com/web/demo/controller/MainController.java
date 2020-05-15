package com.web.demo.controller;

import com.web.demo.service.MainService;
import com.web.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * MainController
 */
@RestController
public class MainController {

    @Autowired 
    private MainService mainservice;

    @PostMapping(value="/signup")
    public void signUp(@RequestBody User entity) {
        System.out.println("signup");
        mainservice.userMapper(entity);
    }
    
    @GetMapping(value="/login?logout")
    public void logout() {
        System.out.println("logout");
        
    }
    // @PostMapping(value="/login")
    // public boolean login(@RequestBody User entity) {
    //     System.out.println("login");
    //     return false;//mainservice.login(entity);
    // }
}