package hometask01;

import java.util.Scanner;

public class HomeTask0103 {
    /*Задание 3
Дано натуральное число n. Определить, является ли год с таким номером високосным
(Год является високосным в двух случаях: либо он кратен 4, но при этом не кратен 100, либо он кратен 400).
Год не является високосным, если он не кратен 4, либо он кратен 100, но при этом не кратен 400.)


     */

    public static void main(String[] args) {
       int year=2000;
       if (((year%4==0)&&(year%100!=0))||(year%400==0)){
            System.out.println("Год "+year+" високосный");
            return;
        }
        System.out.println("Год "+year+" НЕ високосный");
    }
}
