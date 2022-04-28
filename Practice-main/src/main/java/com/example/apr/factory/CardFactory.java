package com.example.apr.factory;

import com.example.apr.model.Card;
import com.example.apr.model.CardType;
import com.example.apr.model.CreditCard;
import com.example.apr.model.DebitCard;

public class CardFactory {
    public Card createCard(CardType type){
        if (type.equals(CardType.DEBIT))
            return new DebitCard();
        return new CreditCard();
    }
}
