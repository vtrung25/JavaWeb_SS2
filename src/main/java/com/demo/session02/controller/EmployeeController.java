package com.demo.session02.controller;

import com.demo.session02.model.Employee;
import com.demo.session02.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employees(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("technicalSalaryTotal", employeeService.getTechnicalDepartmentSalaryTotal());
        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String employeeDetail(@PathVariable("code") String code, HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        Employee employee = employeeService.getByCode(code);
        boolean canViewSalary = "hr_manager".equals(session.getAttribute("role"));

        model.addAttribute("employee", employee);
        model.addAttribute("canViewSalary", canViewSalary);
        return "employee-detail";
    }
}

