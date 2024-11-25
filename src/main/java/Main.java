import ru.gb.Employees;
import ru.gb.Manager;
import ru.gb.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ru.gb.Employees.birthDateComparator;

public class Main {
    public static void main(String[] args) {
        Employees sergey = new Employees("Маликов", "Сергей", "Петрович", LocalDate.of(1980, 5, 15), "Менеджер проекта", 320);
        Employees natalia = new Employees("Степанова", "Наталья", "Ивановна", LocalDate.of(1988, 8, 24), "Бухгалтер", 110);
        Employees ivan = new Employees("Бутусов", "Иван", "Сергеевич", LocalDate.of(1990, 5, 15), "Менеджер продукта", 320);
        Employees viktoria = new Employees("Лобкова", "Виктория", "Игоревна", LocalDate.of(1992, 1, 8), "Эксперт по связям с общественностью", 170);
        Employees maksim = new Employees("Нестеров", "Максим", "Максимович", LocalDate.of(1999, 3, 8), "Программист", 235);
        Employees olga = new Employees("Прохоренко", "Ольга", "Алексеевна", LocalDate.of(2005, 12, 5), "Дизайнер", 210);
        Employees aleksey = new Employees("Петров", "Алексей", "Александрович", LocalDate.of(1974, 10, 10), "Главный бухгалтер", 180);
        Employees irina = new Employees("Красавина", "Ирина", "Ивановна", LocalDate.of(1992, 1, 8), "Экономист", 150);

// Задача 1. Сравнение с использованием компаратора
        if (birthDateComparator().compare(sergey, olga) > 0) {
            System.out.println(sergey.getFirstName() + " старше, чем " + olga.getFirstName());
            System.out.println("=#=#=#=#=#=#=#=#=");
        } else if (birthDateComparator().compare(sergey, olga) < 0) {
            System.out.println(sergey.getFirstName() + " младше, чем " + olga.getFirstName());
            System.out.println("=#=#=#=#=#=#=#=#=");
        } else {
            System.out.println(sergey.getFirstName() + " и " + olga.getFirstName() + " родились в один день");
            System.out.println("=#=#=#=#=#=#=#=#=");
        }


// Задача 2. Пример использования в основной программе
        Manager stepin = new Manager("Степин", "Михаил", "Петрович", LocalDate.of(1938, 5, 9), "Руководитель организации", 410);

        // Создаем массив сотрудников, включая руководителя
        Employees[] employees = {sergey, natalia, ivan, viktoria, maksim, olga, aleksey, irina, stepin};

        // Выводим информацию о зарплате каждого сотрудника до повышения, для дальнейшего контроля
        for (Employees employee : employees) {
            System.out.println(employee.getSurname() + " " + employee.getFirstName() + ", '" + employee.getPosition() + "' " + ": " +
                    "до повышения - " + employee.getSalary());
        }
        System.out.println("=#=#=#=#=#=#=#=#=");


        // Повышаем зарплату всем сотрудникам
        Manager.increaseSalary(employees, 10);

        // Выводим информацию о зарплате каждого сотрудника после повышения
        for (Employees employee : employees) {
            System.out.println(employee.getSurname() + " " + employee.getFirstName() + ", '" + employee.getPosition() + "' " + ": " +
                    "после повышения - " + employee.getSalary());
        }


// Дополнительная задача. Создаем список студентов
        List<Student> students = Arrays.asList(
                new Student("Иван", Arrays.asList(4.5, 5.0, 4.8), "Информатика"),
                new Student("Мария", Arrays.asList(4.0, 4.2, 4.7), "Информатика"),
                new Student("Алексей", Arrays.asList(4.9, 4.8, 5.0), "Математика"),
                new Student("Елена", Arrays.asList(3.5, 4.0, 3.8), "Информатика"),
                new Student("Павел", Arrays.asList(4.7, 4.5, 4.6), "Информатика"),
                new Student("Анна", Arrays.asList(4.2, 4.1, 4.3), "Математика"),
                new Student("Денис", Arrays.asList(4.6, 4.8, 4.9), "Физика"),
                new Student("Ольга", Arrays.asList(4.3, 4.5, 4.2), "Информатика"),
                new Student("Сергей", Arrays.asList(4.7, 4.9, 4.5), "Химия"),
                new Student("Татьяна", Arrays.asList(4.1, 4.0, 4.2), "Геометрия")
        );

        // Находим первые 5 студентов по условиям задачи
        List<Student> result = students.stream()
                .filter(student -> student.getSpecialty().equals("Информатика"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("+=+=+=+=+=+=+=////=+=+=+=+=+=+=+");

        // Выводим результат
        result.forEach(student ->
                System.out.println("Студент: " + student.getName() +
                        ", Специальность: " + student.getSpecialty() +
                        ", Средний балл: " + student.getAverageGrade()));
    }

}


