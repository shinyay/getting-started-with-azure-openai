package com.microsoft.shinyay.ai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleViewController {

    private final SimpleAiController simpleAiController;

    public SimpleViewController(SimpleAiController simpleAiController) {
        this.simpleAiController = simpleAiController;
    }

    @GetMapping("/")
    public String simpleView() {
        return "simple-view";
    }

    @PostMapping("/generate")
    public String generatePrompt(@RequestParam("prompt") String prompt, Model model) {
        String response = simpleAiController.sendPromptAndReceiveResponse(prompt).replace("\n", "<br>");
        model.addAttribute("response", response);
        return "simple-view";
    }
}
