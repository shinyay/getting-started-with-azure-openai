package com.microsoft.shinyay.ai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ai")
public class SimpleAiController {

    private final ChatClient chatClient;

    public SimpleAiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/recipe")
    public String generateRecipeForm(Model model) {
        model.addAttribute("prompt", new Prompt());
        return "simple-ai-view";
    }

    @PostMapping("/recipe")
    public String generateRecipe(@ModelAttribute Prompt prompt, Model model) {
        // Assuming the ChatClient has a method to call Azure OpenAI Service
        String result = chatClient.call(prompt.getText());
        model.addAttribute("result", result);
        return "simple-ai-view";
    }

    static class Prompt {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
