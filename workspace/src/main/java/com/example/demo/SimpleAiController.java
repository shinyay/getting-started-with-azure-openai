package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.ChatClient;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    @Autowired
    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }

    @GetMapping("/ai/joke")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a funny joke in Japanese") String message) {
        return chatClient.call(message);
    }
}
