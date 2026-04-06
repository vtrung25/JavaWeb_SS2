package com.demo.session02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        // Gia lap ten nhan vien de hien thi tren JSP.
        model.addAttribute("employeeName", "Nguyen Van A");
        return "welcome";
    }
}

