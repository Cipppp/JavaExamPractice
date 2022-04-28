package com.example.apr.controller;

import com.example.apr.model.Card;
import com.example.apr.repository.CardRepository;
import com.example.apr.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardRepository cardRepository;
    @PostMapping("/client/{clientId}/withdraw-Money")
    public String withdrawMoney(@PathVariable  Long clientId, Long sum){
        Card c = cardRepository.findCardByClientId(clientId);
        cardService.withdrawMoney(sum, c);
        return "Succes";
    }
}
