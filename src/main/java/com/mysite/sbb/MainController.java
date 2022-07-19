package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class MainController {
    @GetMapping("/sbb")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "민영");
        return "greeting";
    }
}
