package hometask01;


import java.io.IOException;
import java.util.Scanner;

public class HomeTask0113 {
    /*Задание 13
Ввести целое число и определить, верно ли, что в его записи есть две одинаковые цифры.
Пример:
Введите целое число:
1234   1224
Нет     Да
     */

    public static void main(String[] args) throws IOException {

        System.out.println("Введите целое число:");
        int number = new Scanner(System.in).nextInt();
        System.out.println("number=" + number);

        int[] numerals=new int[9];
        for (;number!=0;number/=10){
            //цифра - индекс,частота - значение элемента под этим индексом
            int ind=number%10;
            numerals[ind]++;
            if (numerals[ind]==2){
                System.out.println("Да");
                return;
            }

        }
        System.out.println("Нет");


    }


}
