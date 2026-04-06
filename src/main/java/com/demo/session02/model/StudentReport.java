package com.demo.session02.model;

public class StudentReport {
    private final String studentId;
    private final String fullName;
    private final double score;

    public StudentReport(String studentId, String fullName, double score) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getScore() {
        return score;
    }
}

