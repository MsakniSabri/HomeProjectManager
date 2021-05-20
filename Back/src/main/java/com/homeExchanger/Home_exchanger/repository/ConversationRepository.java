package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByPerson1_id(Integer person1_id);
    List<Conversation> findByPerson2_id(Integer person2_id);
}
