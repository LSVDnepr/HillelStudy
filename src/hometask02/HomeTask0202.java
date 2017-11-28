package hometask02;

import java.util.Scanner;

public class HomeTask0202 {
    /* Задача 2
    Написать программу, которая выводит содержимое массива наоборот.
    Пример:
    Введите пять чисел:
    4 15 3 10 14
    Вывод на экран массива «наоборот»
    14 10 3 15 4
     */
    public static void main(String[] args) {
        int []arr=new int[5];
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите пять чисел: ");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Элементы массива в обратном порядке:");
        for (int j=arr.length-1;j>=0;j--){
            System.out.print(arr[j]+" ");
        }
    }





}
