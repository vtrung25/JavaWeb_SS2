package com.demo.session02.controller;

import com.demo.session02.model.StudentReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String report(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<StudentReport> reports = List.of(
                new StudentReport("SV001", "Le Thi An", 8.7),
                new StudentReport("SV002", "Tran Van Binh", 6.2),
                new StudentReport("SV003", "Pham Minh Chau", 4.8)
        );

        // Du lieu keyword den tu request, JSP se in bang c:out de tranh XSS.
        model.addAttribute("keyword", keyword);
        model.addAttribute("reports", reports);
        return "report";
    }
}

