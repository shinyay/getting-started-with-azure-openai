package com.microsoft.shinyay.ai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleViewController {

    private final SimpleAiController aiController;

    public SimpleViewController(SimpleAiController aiController) {
        this.aiController = aiController;
    }

    @GetMapping("/")
    public String simpleView() {
        return "simple-view";
    }

    @PostMapping("/submit")
    public String submitPrompt(@RequestParam("prompt") String prompt, Model model) {
        String response = aiController.callAzureOpenAI(prompt);
        model.addAttribute("response", response);
        return "simple-view";
    }
}
