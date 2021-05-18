package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.User;
import com.homeExchanger.Home_exchanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(@RequestParam(required = false) String title){
        return "GetAllUsers";
    }

}
