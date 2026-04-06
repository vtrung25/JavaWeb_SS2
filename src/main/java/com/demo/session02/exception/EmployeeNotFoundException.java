package com.demo.session02.exception;

public class EmployeeNotFoundException extends RuntimeException {
    private final String employeeCode;

    public EmployeeNotFoundException(String employeeCode) {
        super("Nhan vien [" + employeeCode + "] khong ton tai trong he thong");
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }
}

