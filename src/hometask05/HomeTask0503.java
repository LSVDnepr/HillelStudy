package hometask05;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class HomeTask0503 {
    /*
    Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
	Scanner scanner=new Scanner(System.in);
	System.out.print(“Enter a sentence:\t”);
    String sentence=scanner.nextLine();

     */

    public final static boolean IS_ASCENDING_ORDER = true;
    public final static int N = 5;

    public static void main(String[] args) {
        //заполнить список, массив...
        System.out.println("Введите " + N + " строк");
        String[] sArr = new String[N];
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<N;i++) {
            sArr[i] = sc.nextLine();
        }

        sortStrings(sArr,IS_ASCENDING_ORDER);
        for (String s:sArr){
            System.out.println(s);
        }

    }




    public static void sortStrings(String[] ar, boolean isAscending) {
        BiPredicate<String, String> bp = (isAscending ? (s1, s2) -> s1.length() < s2.length() : (s1, s2) -> s1.length() > s2.length());
        for (int i = ar.length; i>1 ; i--) {
            for (int j = 1; j < i; j++) {
                if (bp.test(ar[j], ar[j-1])) {
                    String temp = ar[j-1];
                    ar[j-1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
}
