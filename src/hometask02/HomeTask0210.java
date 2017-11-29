package hometask02;

import java.util.Arrays;
import java.util.Random;

public class HomeTask0210 {
    /*Задача 10
    Заполнить массив случайными числами и выделить в другой массив все числа, которые встречаются более одного раза.
     */

    public static void main(String[] args) {
        int[] rndAr = new int[25];
        Random rnd = new Random(777); //DELETE SEED AFTER DEBUG

        for (int i = 0; i < rndAr.length; i++) {//Заполняю массив случайными числами
            rndAr[i] = rnd.nextInt(10);
            System.out.print(rndAr[i] + " ");
        }
        System.out.println();

        Arrays.sort(rndAr);  //Сортирую исходный массив
        int[] duplicates = new int[rndAr.length];
        int ind = 0;
        for (int i = 0; i < rndAr.length; i++) {
            int numToCheck = rndAr[i];
            if (rndAr[i + 1] != numToCheck) continue;
            duplicates[ind] = numToCheck;
            ind++;

            for (int j = i; j < rndAr.length; j++) {
                if (rndAr[j] != numToCheck) {
                    i = j - 1;
                    break;
                }
                if (j == rndAr.length - 1) {
                    i = j;
                }

            }
        }

        //<VARIANT 2>
        /*for (int i = 1; i < rndAr.length; i++) {
            if (rndAr[i] != rndAr[i - 1]) continue;
            duplicates[ind] = rndAr[i];
            ind++;

            for (i += 1; (i < rndAr.length) && (rndAr[i - 1] == rndAr[i]); i++) ;
        }*/

        //</VARIANT 2>



        //<VARIANT 3>
       /* for (int i = 1; i < rndAr.length; i++) {
            if (rndAr[i] != rndAr[i - 1]) continue;
            if (ind == 0 || duplicates[ind-1] != rndAr[i]) {
                duplicates[ind] = rndAr[i];
                ind++;
            }
        }*/

        //</VARIANT 3>



        System.out.println("\nМассив повторов: ");
        duplicates = Arrays.copyOf(duplicates, ind);
        for (int i : duplicates) {
            System.out.print(i + " ");
        }

    }


}
