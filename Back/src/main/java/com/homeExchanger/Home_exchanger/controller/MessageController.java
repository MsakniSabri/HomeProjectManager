package com.homeExchanger.Home_exchanger.controller;



import com.homeExchanger.Home_exchanger.model.Message;
import com.homeExchanger.Home_exchanger.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    ConversationRepository conversationRepository;

    @GetMapping("/")
    public ResponseEntity<HttpStatus> connexion(){
        System.out.println("You are connected");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
