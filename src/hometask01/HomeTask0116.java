package hometask01;

import java.util.Scanner;

public class HomeTask0116 {
    public static void main(String[] args) {
        /*Задание 16
     Пользователь с клавиатуры последовательно вводит целые числа.
     Как только пользователь ввел 0, необходимо показать на экран сумму всех введенных чисел.
         */
        Scanner sc = new Scanner(System.in);
        int num;
        int sum = 0;
        System.out.println("Введите целые числа, отличные от нуля, для подсчета суммы:");
        while ((num = sc.nextInt()) != 0) {
            sum += num;
        }
        System.out.println("Сумма=" + sum);


    }
}
