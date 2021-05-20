package com.homeExchanger.Home_exchanger.controller;



import com.homeExchanger.Home_exchanger.model.Conversation;
import com.homeExchanger.Home_exchanger.model.Message;
import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.MessageRepository;
import com.homeExchanger.Home_exchanger.repository.PersonRepository;
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
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ConversationRepository conversationRepository;

    @GetMapping("/")
    public ResponseEntity<HttpStatus> connexion(){
        System.out.println("You are connected");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages(@RequestParam(required = false) String message) {
        try{
            System.out.println("Get all messages");
            List<Message> messages = new ArrayList<>();

            if (message == null)
                messageRepository.findAll().forEach(messages::add);
            else
                messageRepository.findByMessage(message).forEach(messages::add);


            if(messages.isEmpty()) {
                System.out.println("No content");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        Optional<Message> messageData = messageRepository.findById(id);
        System.out.println("Get message with id : " + id);
        if(messageData.isPresent()) {
            return new ResponseEntity<>(messageData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/persons/{personId}/messages")
    public ResponseEntity<List<Message>> getAllMessagesByConversationId(@PathVariable (value = "conversationId") Long conversationId){
        Optional<Conversation> conversationData = conversationRepository.findById(conversationId);
        System.out.println("Get messages from this user : " + conversationId);
        if(conversationData.isPresent()){
            List<Message> messages = new ArrayList<>();
            messageRepository.findByConversation(conversationData.get()).forEach(messages::add);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persons/{personId}/messages")
    public ResponseEntity<Message> createMessage(@PathVariable Long conversationId, @RequestBody Message message){
        try{
            Optional<Conversation> conversationData = conversationRepository.findById(conversationId);
            System.out.println("Create a message from this user : " + conversationId);
            if(conversationData.isPresent()) {
                Message newMessage = new Message(conversationData.get());
                newMessage.setMessage(message.getMessage());
                Message _message = messageRepository.save(newMessage);
                return new ResponseEntity<>(_message, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<HttpStatus> deleteMessage (@PathVariable("id") Long id){
        try{
            messageRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/messages")
    public ResponseEntity<HttpStatus> deleteAllMessages() {
        try{
            messageRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
