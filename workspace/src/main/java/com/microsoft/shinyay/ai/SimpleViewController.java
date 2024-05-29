package com.microsoft.shinyay.ai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleViewController {

    @GetMapping("/")
    public String showForm() {
        return "simpleView";
    }
}
