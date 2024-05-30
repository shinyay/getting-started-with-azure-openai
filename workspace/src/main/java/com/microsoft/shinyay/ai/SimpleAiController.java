package com.microsoft.shinyay.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    @Autowired
    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/prompt")
    public String callAzureOpenAI(@RequestParam(value = "prompt", defaultValue = "Tell me the benefit of Spring Framework in Japanese") String prompt) {
        return chatClient.prompt().user(prompt).call().content();
    }
}
