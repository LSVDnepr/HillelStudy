package hometask01;

import java.util.Scanner;

public class HomeTask0106 {
    /*
    Задание 6
Ввести возраст человека (от 1 до 150 лет) и вывести его вместе с следующим словом «год», «года» или «лет».
Пример
Введите возраст: 24
Вам 24 года

Введите возраст: 57
Вам 57 лет

     */


    public static void main(String[] args) {

        System.out.println("Введите возраст:");
        int age=new Scanner(System.in).nextInt();
        if ((age<1)||(age>150)){
            System.out.println("Указанный возраст выходит за пределы допустимых значений.");
            return;
        }
        int lastNum=age%10;
        String s;
        switch(lastNum){
            case 1: s=" год";break;
            case 2:
            case 3:
            case 4: s=" года";break;
            default:s=" лет";
        }
        if ((age%100>10)&&(age%100<20)) s=" лет";
        System.out.println("Вам "+age+s);


    }
}
