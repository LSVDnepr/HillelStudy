package hometask05;

public class HomeTask0501 {
    /*
    Задача 1
    Даны строки разной длины, необходимо вернуть их первую половину.
    Пример введения:
    firstHalf(“WooHoo”)->”Woo”
    firstHalf(“HelloThere”)->”Hello”
    firstHalf(“abcdef”)->”abc”
     */

    public static void main(String[] args) {
        /*System.out.println(firstHalf("WooHoo"));
        System.out.println(firstHalf("HelloThere"));
        System.out.println(firstHalf("abcdef"));*/
        String[] ar = {"WooHoo", "HelloThere", "abcdef"};
        for (String s : ar) {
            System.out.println(firstHalf(s));
        }

    }


    public static String firstHalf(String s) {
        if (s.isEmpty()) {
            System.out.println("Передана пустая строка");
            return s;
        }
        return (s.substring(0, s.length() / 2));

    }


}
