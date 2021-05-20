package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}
