package hometask03;

import java.util.Scanner;

public class HomeTask0303 {
    /*
    Составить функцию, которая определяет, верно ли, что в заданном числе все цифры стоят по возрастанию.
    Пример:
    Введите число:
    258
    Верно.
     */

    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int num=new Scanner(System.in).nextInt();
        System.out.println(areNumsAscending(num)?"Верно":"Неверно");

    }


    public static boolean areNumsAscending(int num){
        for (;num>9;num/=10){
            if (num%10<(num/10)%10) return false;
        }
        return true;
    }







}
