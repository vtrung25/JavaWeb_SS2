package com.demo.session02.controller;

import com.demo.session02.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class EventController {

    @GetMapping("/events/search")
    public String search(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                         Model model) {
        List<Event> allEvents = List.of(
                new Event(1L, "Spring Framework Conference", "12/05/2026", 1200000, 25),
                new Event(2L, "Java Web Basics", "20/05/2026", 0, 120),
                new Event(3L, "DevOps Night", "28/05/2026", 450000, 8),
                new Event(4L, "Microservices Masterclass", "03/06/2026", 900000, 0),
                new Event(5L, "UI/UX with \"Figma\" & <b>Design</b>", "07/06/2026", 350000, 5)
        );

        String normalizedKeyword = keyword == null ? "" : keyword.trim();
        String keywordLower = normalizedKeyword.toLowerCase(Locale.ROOT);

        List<Event> filteredEvents;
        if (keywordLower.isEmpty()) {
            filteredEvents = allEvents;
        } else {
            filteredEvents = allEvents.stream()
                    .filter(event -> event.getName().toLowerCase(Locale.ROOT).contains(keywordLower))
                    .collect(Collectors.toList());
        }

        model.addAttribute("keyword", normalizedKeyword);
        model.addAttribute("events", filteredEvents);
        return "events/search";
    }

    @GetMapping("/events/{id}/book")
    public String bookTicket(@PathVariable("id") Long id, Model model) {
        // Trang dat ve gia lap de link trong ket qua tim kiem khong bi loi 404.
        model.addAttribute("bookingMessage", "Da nhan yeu cau dat ve cho su kien ID: " + id);
        return "events/book-result";
    }
}

