package hometask03;

import java.util.Random;

public class HomeTask0304 {
    /*
    Написать программу с функциями для подсчета среднего арифметического массива для различных типов данных (int, float)
     */

    public static final int ARRAY_SIZE = 25;

    public static void main(String[] args) {
        int[] ar1 = new int[ARRAY_SIZE];
        Random rnd = new Random(75);//delete seed later
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = rnd.nextInt(100);//delete bound later;
        }

        System.out.println("Массив целых чисел:");
        for (int el : ar1) {
            System.out.print(el + " ");
        }

        float avr1 = average(ar1);
        System.out.printf("\nСреднее арифметическое массива целых чисел=%5.4f%n", avr1);

        float[] ar2 = new float[ARRAY_SIZE];
        for (int i = 0; i < ar1.length; i++) {
            ar2[i] = rnd.nextFloat() * 100;
        }

        System.out.println("\nМассив вещественных чисел:");
        for (float el : ar2) {
            System.out.printf("%5.4f  ", el);
        }
        float avr2 = average(ar2);
        System.out.printf("\nСреднее арифметическое массива вещественных чисел=%5.4f%n", avr2);

    }


    public static float average(int[] ar) {

        long sum = 0; //long, чтобы избежать переполнения
        for (int el : ar) {
            sum += el;
        }
        return ((float) sum / ar.length);
    }

    public static float average(float[] ar) {
        float sum = 0;
        for (float el : ar) {
            sum += el;
        }

        return (sum / ar.length);
    }


}
