package com.microsoft.shinyay.ai.controller;

import com.microsoft.shinyay.ai.service.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    @Autowired
    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/joke")
    public String getJoke() {
        // Assuming ChatClient has a method generateJoke() to generate a joke
        return chatClient.generateJoke();
    }
}
