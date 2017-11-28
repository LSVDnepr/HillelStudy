package hometask02;

import java.util.Random;

public class HomeTask0216 {
    /*
    Заполнить массив из 10 элементов случайными числами в интервале [0..100] и отсортировать первую половину по возрастанию, а вторую – по убыванию.
    Пример:
    Исходный массив:
    14 25 13 30 76 | 58 32 11 41 97
    Результат:
    13 14 25 30 76 |97 58 41 32 11
     */

    public static void main(String[] args) {
        int[] ar = new int[10];
        Random r = new Random(88);//delete seed later
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(101);
        }
        System.out.println("Исходный массив");

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
            if (i == ar.length/2-1) {
                System.out.print(" | ");
            }

        }
        System.out.println();

       sortArray(ar,0,ar.length/2,true);
       sortArray(ar,ar.length/2,ar.length,false);





        System.out.println("отсортированный массив:");
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
            if (i == ar.length/2-1) {
                System.out.print(" | ");
            }
        }


    }


    public static void sortArray(int[] ar, boolean isAscending) {
        //реализую bubble sort with flag
        boolean allSorted;

        if (isAscending) {
            for (int i = ar.length - 1; i > 0; i--) {
                allSorted = true;
                for (int j = 0; j < i; j++) {
                    if (ar[j] <= ar[j + 1]) continue;
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    allSorted = false;
                }
                if (allSorted) break;

            }
        } else {
            for (int i = ar.length - 1; i > 0; i--) {
                allSorted = true;
                for (int j = 0; j < i; j++) {
                    if (ar[j] >= ar[j + 1]) continue;
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    allSorted = false;
                }
                if (allSorted) break;
            }
        }
    }

    public static void sortArray(int[] ar, int from, int to, boolean isAscending) {
        /*System.out.println("from="+from);
        System.out.println("to="+to);*/
        //to - не включительно

        //реализую bubble sort with flag
        boolean allSorted;

        if (isAscending) {
            for (int i = to-1; i > from; i--) {
               // System.out.println("сортирую от "+ar[from]+"до "+ar[i]);
                allSorted = true;
                for (int j = from; j < i; j++) {

                    if (ar[j] <= ar[j + 1]) continue;
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    allSorted = false;
                }
                if (allSorted) break;

            }
        } else {
            for (int i = to-1; i > from; i--) {
                //System.out.println("сортирую от "+ar[from]+" до "+ar[i]);
                allSorted = true;
                for (int j = from; j <i ; j++) {
                    if (ar[j] >= ar[j + 1]) continue;
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    allSorted = false;
                }
                if (allSorted) break;
            }
        }
    }


}
