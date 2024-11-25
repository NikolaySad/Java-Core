package ru.gb;

import java.time.LocalDate;
import java.util.Comparator;

public class Employees {
    private String surname;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String position;
    private double salary;

    public Employees(String surname, String firstName, String lastName, LocalDate birthDate, String position, double salary) {
        this.surname = surname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.salary = salary;
    }

    public java.lang.String getSurname() {
        return surname;
    }

    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.time.LocalDate getBirthday() {
        return birthDate;
    }

    public void setBirthDate(java.time.LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public java.lang.String getPosition() {
        return position;
    }

    public void setPosition(java.lang.String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Прототип компаратора для сравнения двух дат рождения сотрудников
    public static Comparator<Employees> birthDateComparator() {
        return Comparator.comparing(employee -> employee.birthDate);
    }

}
