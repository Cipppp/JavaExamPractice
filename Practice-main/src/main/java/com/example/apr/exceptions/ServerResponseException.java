package com.example.apr.exceptions;

public class ServerResponseException extends Exception{
    public ServerResponseException() {
        super("Server response error");
    }
}
