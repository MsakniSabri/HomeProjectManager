package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {

}
