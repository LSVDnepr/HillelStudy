package hometask01;

import java.util.Scanner;

public class HomeTask0115 {
    /*
        Задание 15
Ввести натуральное число и определить, какие цифры встречаются несколько раз.
Пример:
Введите число>=0:
2323
Повторятся 2,3
Введите число >=0:
1234
Нет повторов
     */

    public static void main(String[] args) {
        System.out.println("Введите число>=0:");
        int num = new Scanner(System.in).nextInt();
        System.out.println("Ваше число: " + num);
        if (num < 0) {
            System.out.println("Нужно положительное число.");
            return;
        }
        int[] numerals = new int[9];

        boolean printedDuplicates = false;
        for (; num != 0; num /= 10) {
            int ind=num % 10;
            numerals[ind]++;
            if (numerals[ind] != 2) continue;

            if (!printedDuplicates) {
                System.out.print("Повторяются " + ind);
                printedDuplicates = true;
            } else {
                System.out.print("," + ind);
            }
        }
        if (!printedDuplicates) System.out.println("Нет повторов");


    }

}
