package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ai.chat.ChatClient;

@Controller
public class SimpleAiController {

    private final ChatClient chatClient;

    @Autowired
    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("message", new String());
        return "simple-ai-view";
    }

    @PostMapping("/ai/recipe")
    public String generate(@RequestParam(value = "message", defaultValue = "Can you give me a recipe for a delicious dish in Japanese?") String message, Model model) {
        String response = chatClient.call(message);
        model.addAttribute("response", response);
        return "simple-ai-view";
    }
}
