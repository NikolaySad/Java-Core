import java.util.Scanner;

import static tasks.Task1.countEvens;
import static tasks.Task2.elementDifference;
import static tasks.Task3.zeroElement;

public static void main(String[] args) {
    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
    System.out.println("Привет! Сейчас тебе будет предложено ввести несколько значений. Пожалуйста введи их.");

    Scanner scanner = new Scanner(System.in);

    System.out.print("Желаемая длина массива: ");
    int lengthArray = scanner.nextInt();

    countEvens(new int[lengthArray]);

    elementDifference(new int[lengthArray]);

    zeroElement(new int[lengthArray]);

}