package com.example.mediator;

public interface ChatMediator {
    void sendMessage(String message, String from, String to);
    void registerClient(ChatClientController client);
}