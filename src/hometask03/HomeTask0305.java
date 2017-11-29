package hometask03;

import java.util.Scanner;

public class HomeTask0305 {
    /*
    Написать программу с функциями для подсчета суммы квадратов двух чисел для различных типов данных (int, float)
    Формула (a*a+b*b)
     */

    public static void main(String[] args) {
        System.out.println("Введите два целых числа:");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Сумма квадратов этих чисел="+sumOfSquares(a,b));
        System.out.println("Введите два вещественных числа:");
        float c=sc.nextFloat();
        float d=sc.nextFloat();
        System.out.println("Сумма квадратов этих чисел="+sumOfSquares(c,d));

    }



    public static long sumOfSquares (int a, int b){ //long, чтобы избежать переполнения
        return (((long)a)*a+b*b);
    }


    public static float sumOfSquares (float a, float b){ //может, лучше double
        return (a*a+b*b);
    }


}
