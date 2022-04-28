package com.example.apr.service;

import com.example.apr.model.Card;
import com.example.apr.model.Client;
import com.example.apr.repository.CardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public Boolean withdrawMoney(Long sum, Card card){
        if(sum > card.getAccount().getAmount())
            return false;
        else
        {
            card.getAccount().setAmount(card.getAccount().getAmount() - sum);
            cardRepository.save(card);
            return true;
        }
    }
}
