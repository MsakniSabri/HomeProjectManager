package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<Housing> findByTitle(String title);
    List<Housing> findByAvailable(Boolean isAvailable);
    List<Housing> findByTitleAndAvailable(String title, Boolean isAvailable);
}
