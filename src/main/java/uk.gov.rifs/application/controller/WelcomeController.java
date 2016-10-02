package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String greeting(Model model) {

        return "welcome";
    }
}
