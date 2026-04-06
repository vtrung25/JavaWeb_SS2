package com.demo.session02.model;

import java.util.Date;

public class Employee {
    private final String code;
    private final String fullName;
    private final String department;
    private final long salary;
    private final Date joinDate;
    private final String status;

    public Employee(String code, String fullName, String department, long salary, Date joinDate, String status) {
        this.code = code;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public long getSalary() {
        return salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getStatus() {
        return status;
    }
}

