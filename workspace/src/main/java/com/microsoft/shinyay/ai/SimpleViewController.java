package com.microsoft.shinyay.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleViewController {

    private final ChatClient chatClient;

    public SimpleViewController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/")
    public String simpleView(Model model) {
        model.addAttribute("response", "");
        return "simple-view";
    }

    @PostMapping("/submit")
    public String submitPrompt(@RequestParam("prompt") String prompt, Model model) {
        // Simulate setting the result from the prompt to the model
        String response = chatClient.prompt().user(prompt).call().content();
        String result = "Response to: " + response;
        model.addAttribute("response", result);
        return "simple-view";
    }
}
