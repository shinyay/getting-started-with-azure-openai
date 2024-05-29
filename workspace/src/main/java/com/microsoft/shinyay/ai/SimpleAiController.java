package com.microsoft.shinyay.ai;

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

    @GetMapping("/ai/recipe")
    public String getRecipe(@RequestParam(value = "userInput", defaultValue = "Tell me a delicious food recipe") String userInput) {
        return chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
