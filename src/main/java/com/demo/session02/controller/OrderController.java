package com.demo.session02.controller;

import com.demo.session02.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    private final Object counterLock = new Object();


    @GetMapping("/orders")
    public String orders(HttpSession session,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         Model model) {
        Object loggedUser = session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        List<Order> orders = List.of(
                new Order("OD001", "Ban phim co", 450000, new Date(System.currentTimeMillis() - 2L * 24 * 60 * 60 * 1000)),
                new Order("OD002", "Chuot khong day", 320000, new Date(System.currentTimeMillis() - 24L * 60 * 60 * 1000)),
                new Order("OD003", "Tai nghe", 780000, new Date()),
                new Order("OD004", "Man hinh 24 inch", 2890000, new Date())
        );

        int totalViewCount = increaseGlobalViewCount(request.getServletContext());

        // Chan cache de sau logout bam Back se request lai va bi redirect ve /login.
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        model.addAttribute("orders", orders);
        model.addAttribute("totalViewCount", totalViewCount);
        return "orders";
    }

    private int increaseGlobalViewCount(ServletContext application) {
        synchronized (counterLock) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            application.setAttribute("totalViewCount", count);
            return count;
        }
    }
}


