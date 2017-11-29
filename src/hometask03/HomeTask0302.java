package hometask03;

import java.util.Scanner;

public class HomeTask0302 {
    /*
    Составить функцию, которая определяет, верно ли, что сумма цифр числа – четное число
    Пример:
    Введите число:
    136
    Сумма цифр четная.
     */

    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println(isNumeralSumEven2(num)?"Сумма цифр четная.":"Сумма цифр не четная.");

    }

    public static boolean isNumeralSumEven2(int num) {
        int sum = 0;
        for (; num > 0; num /= 10) {
            sum += num % 10;
        }
        return sum%2==0;
    }


}
