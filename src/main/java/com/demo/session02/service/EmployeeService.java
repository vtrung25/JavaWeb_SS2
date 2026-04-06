package com.demo.session02.service;

import com.demo.session02.exception.EmployeeNotFoundException;
import com.demo.session02.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = List.of(
            new Employee("NV001", "Nguyen Thi Lan", "Ke toan", 15_000_000, toDate(2020, 3, 1), "Dang lam"),
            new Employee("NV002", "Tran Van Hung", "Ky thuat", 25_000_000, toDate(2019, 7, 15), "Dang lam"),
            new Employee("NV003", "Le Minh Duc", "Kinh doanh", 18_500_000, toDate(2021, 11, 20), "Nghi phep"),
            new Employee("NV004", "Pham Thu Huong", "Ky thuat", 22_000_000, toDate(2022, 1, 5), "Dang lam"),
            new Employee("NV005", "Hoang Van Nam", "Ke toan", 12_000_000, toDate(2023, 6, 10), "Thu viec")
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public long getTechnicalDepartmentSalaryTotal() {
        return employees.stream()
                .filter(employee -> "Ky thuat".equals(employee.getDepartment()))
                .mapToLong(Employee::getSalary)
                .sum();
    }

    public Employee getByCode(String code) {
        return employees.stream()
                .filter(employee -> employee.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(code));
    }

    private Date toDate(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    }
}

