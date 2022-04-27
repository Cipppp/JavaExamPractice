package com.practice2.demo.errors;

public class PostNotFoundException extends Exception{
    public PostNotFoundException(String message) {
        super(message);
    }
}
