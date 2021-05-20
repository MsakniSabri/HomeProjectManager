package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.Conversation;
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
public class ConversationController {

    @Autowired
    ConversationRepository conversationRepository;

    @GetMapping("/")
    public ResponseEntity<HttpStatus> connexion(){
        System.out.println("You are connected");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/conversations")
    public ResponseEntity<List<Conversation>> getAllConversationsForUser(@RequestParam(required = true) Integer user_id) {
        try{
            System.out.println("Get all housings");
            List<Conversation> conversations = new ArrayList<>();

            conversationRepository.findByPerson1_id(user_id).forEach(conversations::add);
            conversationRepository.findByPerson2_id(user_id).forEach(conversations::add);

            if(conversations.isEmpty()) {
                System.out.println("No content");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(conversations, HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
