package com.example.apr.exceptions;

public class CountryOnBlacklistException extends Exception{
    public CountryOnBlacklistException() {
        super("Sorry, your country is on blacklist");
    }
}
