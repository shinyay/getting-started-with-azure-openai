package com.example.demo;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/joke")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a funny joke in Japanese") String message) {
        return chatClient.call(message);
    }
}
