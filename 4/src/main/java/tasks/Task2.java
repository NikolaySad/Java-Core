package tasks;

// Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами
// переданного не пустого массива.

import java.util.Random;


public class Task2 {
    public static int[] elementDifference(int[] arrayTwo) {
        Random random = new Random();
        int min = 30, max = 0;
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = random.nextInt(30);
            System.out.print("[" + arrayTwo[i] + "] ");
            if (arrayTwo[i] > max) {
                max = arrayTwo[i];
            } else if (arrayTwo[i] < min) {
                min = arrayTwo[i];
            }
        }
        int result = max - min;
        System.out.println("\n" + "Разница между самым большим и самым маленьким элементами второго массива: " + result);
        return arrayTwo;

    }
}