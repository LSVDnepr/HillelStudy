package hometask01;

import java.util.Scanner;

public class HomeTask0112 {
    /*Задание 12
Ввести целое число и найти сумму его цифр.
Пример
Введите целое число:
1234
Сумма цифр числа 1234 равно 10
     */
    public static void main(String[] args) {
        System.out.println("Введите целое число: ");
        int num=new Scanner(System.in).nextInt();
        int number=num;
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        System.out.println("Сумма цифр числа "+number+" равна "+sum);


    //for (sum=0;num!=0;sum+=num%10,num/=10); вариант сокращенной записи цикла

    }

}
