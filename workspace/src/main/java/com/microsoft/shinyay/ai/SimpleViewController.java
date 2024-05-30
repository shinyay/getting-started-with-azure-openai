package com.microsoft.shinyay.ai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleViewController {

    @GetMapping("/")
    public String simpleView(Model model) {
        model.addAttribute("response", "");
        return "simple-view";
    }

    @PostMapping("/submit")
    public String submitPrompt(@RequestParam("prompt") String prompt, Model model) {
        // Simulate setting the result from the prompt to the model
        String result = "Response to: " + prompt;
        model.addAttribute("response", result);
        return "simple-view";
    }
}
