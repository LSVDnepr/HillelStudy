package hometask02;

import java.util.Scanner;

public class HomeTask0201 {
    /*Задача 1
    Ввести с клавиатуры массив из 5 элементов, найти среднее арифметическое всех элементов массива
    Пример:
    Введите 5 чисел:
    4 15 3 10 14
    среднее арифметическое 9.200
     */

    public static void main(String[] args) {

        int[] num=new int[5];
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите 5 чисел:");
        int sum=0;
        for (int i=0;i<num.length;i++){
            num[i]=sc.nextInt();
            sum+=num[i];
        }
        System.out.printf("Среднее арифметическое %5.3f",(double)sum/num.length);



    }
}
