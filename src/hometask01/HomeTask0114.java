package hometask01;

import java.util.Scanner;

public class HomeTask0114 {
    /*Задача 14
    Ввести натуральное число и определить, верно ли, что сумма его цифр равна 10.
Пример
Введите число >=0 :
-234
Нужно положительное число.
Введите число >=0:
1234:
Да
Введите число >=0:
1233
Нет


     */

    public static void main(String[] args) {
        System.out.println("Введите число>=0:");
        int num=new Scanner(System.in).nextInt();
        System.out.println(num);
        if (num<0){
            System.out.println("Нужно положительное число.");
            return;
        }
        int numeralSum=0;
        for (;num>0;num/=10){
            numeralSum+=num%10;
        }

        System.out.println(numeralSum==10?"Да":"Нет");
    }

}
