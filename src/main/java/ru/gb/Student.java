package ru.gb;

import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public double getAverageGrade() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}

