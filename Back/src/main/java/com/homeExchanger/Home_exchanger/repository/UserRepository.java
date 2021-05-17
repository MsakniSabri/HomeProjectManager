package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
