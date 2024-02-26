package com.example.fooddeliveryservice.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message, String recipient) {
        // This method would integrate with an external notification service like KakaoTalk
        // For the purpose of this example, we'll just print the message to the console
        System.out.println("Sending notification to " + recipient + ": " + message);
    }

    // Other methods related to notification operations
}