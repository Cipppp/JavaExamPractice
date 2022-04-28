package com.example.apr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String CNP;
    private String serieBuletin;
    private String seriePasaport;
    private String name;
    private String email;

    @OneToMany
    private List<Account> accounts;

    @OneToMany
    private  List<Card> cards;



}
