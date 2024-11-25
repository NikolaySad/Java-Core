# Java Core (семинары)

## Урок 6. Классы и объекты

### Задача 1.

Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.

#### Решение

Для этого можно использовать класс LocalDate из пакета java.time, который предоставляет удобные методы для работы с датами. Вот пример прототипа компаратора внутри класса сотрудника:

<details>

  <summary>Нажмите, чтобы открыть код</summary>

```java
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
```

</details>

Здесь birthDateComparator() возвращает компаратор, который сравнивает сотрудников по их дате рождения. Используя Comparator.comparing(), мы избегаем использования условных операторов, так как он самостоятельно сравнивает даты.

---


### Задача 2.

Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.

#### Решение

Давайте добавим класс руководителя (Manager), который будет наследоваться от класса Employee. В этом классе мы определим статический метод для повышения зарплаты, учитывая условие, что зарплата руководителя не должна повышаться.

<details>

  <summary>Нажмите, чтобы открыть код</summary>

```java
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
```
</details>

В этом примере мы добавили метод increaseSalary в класс Manager, который увеличивает зарплату для всех сотрудников, кроме руководителей. Также в основной программе мы создали руководителя и добавили его в массив сотрудников, затем повысили зарплату всем сотрудникам и вывели результат. Зарплата руководителя осталась неизменной.

<details>

<summary>Нажмите, чтобы открыть скриншот проверки</summary>

</details>

---


### Дополнительно:

Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
Найдите первых 5 студентов специальности "Информатика" со средним баллом выше 4.5, отсортированных по убыванию среднего балла.
В решении не использовать циклы! **Только StreamAPI**


> ```java
> class Student {
>     private String name;
>     private List<Double> grades;
>     private String specialty;
> 
>         public double getAverageGrade() {...}
> 
> }
> ```


#### Решение

Используя Stream API, мы можем легко выполнить это задание. Давайте создадим список студентов и применим необходимые операции:

<details>

  <summary>Нажмите, чтобы открыть код</summary>

```java
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



