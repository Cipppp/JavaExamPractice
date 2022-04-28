package com.example.apr.repository;

import com.example.apr.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    public Card findCardByClientId(Long clientId);
}
