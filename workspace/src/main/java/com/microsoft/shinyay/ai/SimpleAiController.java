package com.microsoft.shinyay.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    public SimpleAiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/prompt")
    public String getPromptResponse(@RequestParam String prompt) {
        return chatClient.prompt().user(prompt).call().content();
    }
}
