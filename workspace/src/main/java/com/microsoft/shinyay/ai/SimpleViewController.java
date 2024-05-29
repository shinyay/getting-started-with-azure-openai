package com.microsoft.shinyay.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SimpleViewController {

    private final ChatClient chatClient;
    private final Logger logger = LoggerFactory.getLogger(SimpleViewController.class);

    public SimpleViewController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/")
    public String showForm() {
        return "simpleView";
    }

    @PostMapping("/")
    public String handlePostRequest(@RequestParam("prompt") String prompt, Model model) {
        String response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();
        String result = response.replace("\n", "<br>");

        logger.info("Result: " + result);

        // Add the response to the model so it can be displayed in the view.
        model.addAttribute("response", response);

        // Return the name of the view to display. This might be "simpleView" if you
        // have a simpleView.html in your templates folder.
        return "simpleView";
    }
}
