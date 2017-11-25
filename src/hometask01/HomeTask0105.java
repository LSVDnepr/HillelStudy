package hometask01;

import java.util.Scanner;

public class HomeTask0105 {
/*
Задание 5
Ввести номер месяца и вывести название времени года.
Пример:
Введите номер месяца: 4
Время года – весна

 */

    public static void main(String[] args) {

        System.out.println("Введите номер месяца: ");
        int month=new Scanner(System.in).nextInt();
        switch(month){
            case 1:
            case 2:
            case 12:
                System.out.println("Время года - зима"); break;
            case 3:
            case 4:
            case 5:
                System.out.println("Время года - весна");break;
            case 6:
            case 7:
            case 8:
                System.out.println("Время года - лето"); break;
            case 9:
            case 10:
            case 11:
                System.out.println("Время года - осень");break;
            default:
                System.out.println("Заданный номер месяца не соответствует ни одному времени года");
        }





    }

}
