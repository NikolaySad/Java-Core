package ru.company.jcore.hw1.views;

import java.util.ArrayList;
import java.util.Scanner;

public class Conole {
     
    public static ArrayList<Double> userData(){
    ArrayList<Double> dataList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    double weight = userInput("Введите Ваш вес в кг (например 65.3): ", scan);
    dataList.add(weight);

    double height = userInput("Введите Ваш рост в метрах (например 1.75): ", scan);
    dataList.add(height);
    
    scan.close(); //вот теперь мы сделали все правильно!
    return dataList;
  }
  
  private static double userInput(String message, Scanner sc) {
    boolean flag = false;
    double result = 0;
    while (!flag) {
        System.out.print(message);
        String temp = sc.next();
        try {
            result = Double.parseDouble(temp);
            flag = true;
        } catch (NumberFormatException ex) {
            System.out.println("Извините, неверный формат. Попробуйте снова!");
        }
    }
    return result;
    }
}
