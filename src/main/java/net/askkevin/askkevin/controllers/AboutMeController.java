package net.askkevin.askkevin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeController {

    @GetMapping("/about-me")
    public String showAboutForm(){
        return "about-me";
    }

}
