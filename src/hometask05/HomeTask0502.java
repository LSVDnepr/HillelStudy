package hometask05;

import java.util.Scanner;

public class HomeTask0502 {
    /* Задача 2
    Дан String. Нужно вернуть true, если она заканчивается на  “ly”.
     */

    public static void main(String[] args) {
        /*System.out.println("Введите строку");
        System.out.println((new Scanner(System.in).nextLine()).endsWith("ly"));*/


        String str = "really";
        /*System.out.println(str.endsWith("ly"));
        System.out.println("true".endsWith("ly"));
        System.out.println("quickly".endsWith("ly"));*/
        System.out.println(endsWith(str, "ly"));

    }


    public static boolean endsWith(String str, String suffix) {
        return (str.endsWith(suffix));
    }


}
