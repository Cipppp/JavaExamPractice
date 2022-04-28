package com.example.apr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private CardType card;
    private AccountType accountType;

    private Long amount;
    private String IBAN;
    private Client owner;

    @ManyToOne
    private Client client;

    @OneToMany
    private List<Card> cards;
}
