package tasks;

// Написать функцию возвращающую истину,
// если в переданном массиве есть два соседних элемента с нулевым значением.

import java.util.Random;

public class Task3 {
    public static int[] zeroElement(int[] arrayThree) {
        Random random = new Random();
        boolean elZero = false;
        for (int i = 0; i < arrayThree.length; i++) {
            arrayThree[i] = random.nextInt(2);
            System.out.print("[" + arrayThree[i] + "] ");
        }
        for (int j = 0; j < arrayThree.length; j++) {
            if (arrayThree[j] == 0) {
                if (arrayThree[j + 1] == 0 || arrayThree[j - 1] == 0) {
                    elZero = true;
                }
            }
        }
        System.out.println("\n" + "Наличие в третьем массиве двух соседних элементов с нулевым значением: " + elZero);
        return arrayThree;
    }
}
