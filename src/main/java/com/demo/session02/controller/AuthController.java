package com.demo.session02.controller;

import com.demo.session02.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/orders";
        }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpSession session,
                          Model model) {
        String role = authService.authenticate(username, password);
        if (role == null) {
            // Loi dang nhap chi ton tai trong request hien tai.
            model.addAttribute("errorMessage", "Sai ten dang nhap hoac mat khau.");
            return "login";
        }

        session.setAttribute("loggedUser", username);
        session.setAttribute("role", role);
        return "redirect:/orders";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

