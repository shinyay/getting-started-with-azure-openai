package com.microsoft.shinyay.ai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/joke")
    public String getJoke() {
        // Assuming the ChatClient has a method to generate a joke
        return chatClient.generateJoke();
    }
}
