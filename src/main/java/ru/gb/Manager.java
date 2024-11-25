package ru.gb;

import java.time.LocalDate;

public class Manager extends Employees {

    // Конструктор класса Manager
    public Manager(String surname, String firstName, String lastName, LocalDate birthDate, String position, double salary) {
        super(surname, firstName, lastName, birthDate, position, salary);
    }

    // Статический метод для повышения зарплаты
    public static void increaseSalary(Employees[] employees, double percentage) {
        for (Employees employee : employees) {
            if (!(employee instanceof Manager)) {
                double currentSalary = employee.getSalary();
                double newSalary = currentSalary * (1 + percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }

}