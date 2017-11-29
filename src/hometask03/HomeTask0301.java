package hometask03;

import java.util.Scanner;

public class HomeTask0301 {
    /*
    Составить функцию, которая определяет наибольший общий делитель двух натуральных чисел и привести пример ее использования
    Пример:
    Введите два числа: 14  21
    НОД(14,21)=7;

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа >0:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ((a <= 0) || (b <= 0)) {
            System.out.println("Для вычисления НОД числа должны быть строго больше нуля");
            return;
        }

        System.out.println("НОД=" + getNOD(a, b));

    }



    public static int getNOD(int a, int b) {
        int greater = (a >= b ? a : b);
        int less = (b <= a ? b : a);
        if (greater % less == 0) return less;
        greater = greater % less;
        return getNOD(greater, less);

    }


}
