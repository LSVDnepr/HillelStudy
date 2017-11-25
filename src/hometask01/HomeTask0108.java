package hometask01;

import java.util.Scanner;

public class HomeTask0108 {
    /*
    Задание 8
Создать  калькулятор. Пользователь вводит 1-ое число, потом 2-ое число, а потом операцию, которую хочет выполнить (+-* /).
    Калькулятор выдает результат:
    Введите число а: 23
    Введите число b: 35
    Введите операцию (+ - * /): +
    Ответ: 58
            */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число а:");
        int a = sc.nextInt();
        System.out.println("Введите число b:");
        int b = sc.nextInt();
        System.out.println("Введите операцию (+ - * /):");
        char sign = sc.next().charAt(0);
        int result;
        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                result = Integer.MAX_VALUE;
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println("Указанная операция не может быть выполнена");
        } else {
            System.out.println("Ответ: " + result);
        }

    }
}
