package hometask01;

import java.util.Scanner;

public class HomeTask0107 {
    /*
    Задание 7
Ввести номер месяца и вывести количество дней в этом месяце.
Решение: Число дней по месяцам:
28 дней февраль
30 дней – 4(апрель), 6 (июнь), 9 (сентябрь) 11(ноябрь)
31 день – 1 (январь), 3 (март), 5(май), 7 (июль), 8 (август), 10 (октябрь), 12(декабрь)
     */


    public static void main(String[] args) {
        int month = new Scanner(System.in).nextInt();
        int days;
        if ((month < 1) || (month > 12)) {
            System.out.println("Указанный номер не соответствует ни одному месяцу");
            return;
        }

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                break;
            default:
                days = 31;
                break;
        }
        System.out.println("В указанном месяце количество дней=" + days);


    }
}
