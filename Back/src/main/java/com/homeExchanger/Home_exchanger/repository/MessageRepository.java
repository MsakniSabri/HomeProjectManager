package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Conversation;
import com.homeExchanger.Home_exchanger.model.Housing;
import com.homeExchanger.Home_exchanger.model.Message;
import com.homeExchanger.Home_exchanger.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository  extends JpaRepository<Message, Long> {
    List<Message> findByMessage(String message);
    List<Message> findByConversation(Conversation conversation);
    List<Message> findByPerson(Person person);
}
