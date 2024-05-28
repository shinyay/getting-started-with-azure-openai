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

    @GetMapping("/ai/recipe")
    public String generateRecipe() {
        // Assuming the ChatClient has a method to call Azure OpenAI Service
        return chatClient.call("Tell me a delicious food recipe in Japanese");
    }
}
