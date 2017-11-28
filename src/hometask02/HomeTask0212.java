package hometask02;

import java.util.Arrays;
import java.util.Random;

public class HomeTask0212 {
    /*Задача 12
    Выполнить сортировку пузырьком, сортировку пузырьком с флагом и
    сортировку выбором на массиве в 1000 элементов и засечь время выполнения
     */

    public static void main(String[] args) {
        int[] ar=new int[1000];
        Random rnd=new Random(755);//
        for (int i=0;i<ar.length;i++){
            ar[i]=rnd.nextInt();
        }
        System.out.println("Исходный массив:");
        for (int el:ar){
            System.out.print(el+" ");
        }
        System.out.println();

        int[] arCopy1= Arrays.copyOf(ar,ar.length);
        //ВЫПОЛОНЯЮ BUBBLE SORT без флага
        long sort1Start=System.currentTimeMillis();
        bubbleSort(arCopy1,true);
        long sort1Finish=System.currentTimeMillis();
        long duration1=sort1Finish-sort1Start;
        System.gc();


        int[] arCopy2= Arrays.copyOf(ar,ar.length);

        //ВЫПОЛОНЯЮ BUBBLE SORT с флагом
        long sort2Start=System.currentTimeMillis();
        bubbleSortWithFlag(arCopy2,true);
        long sort2Finish=System.currentTimeMillis();
        long duration2=sort2Finish-sort2Start;
        System.gc();

        int[] arCopy3= Arrays.copyOf(ar,ar.length);
        //ВЫПОЛОНЯЮ SELECTION SORT
        long sort3Start=System.currentTimeMillis();
        selectSort(arCopy3,true);
        long sort3Finish=System.currentTimeMillis();
        long duration3=sort3Finish-sort3Start;
        System.gc();


        System.out.println("Duration BubbleSort="+duration1);
        /*for (int i:arCopy1){
            System.out.print(i+" ");
        }
        System.out.println();*/
        System.out.println("Duration BubbleSortWithFlag="+duration2);
        /*for (int i:arCopy2){
            System.out.print(i+" ");
        }
        System.out.println();*/
        System.out.println("Duration SelectionSort="+duration3);
        /*for (int i:arCopy3){
            System.out.print(i+" ");
        }
        System.out.println();*/


    }



    public static void bubbleSort(int[] a,boolean isAscending){
        if (isAscending) {
            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[j] <= a[j + 1]) continue;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        } else {
            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[j] >= a[j + 1])continue;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }


    public static void bubbleSortWithFlag(int[] a, boolean isAscending){
        boolean allSorted;

        if (isAscending) {
            for (int i = a.length - 1; i > 0; i--) {
                allSorted = true;
                for (int j = 0; j < i; j++) {
                    if (a[j] <= a[j + 1]) continue;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    allSorted = false;
                }
                if(allSorted)break;
            }
        } else {
            for (int i = a.length - 1; i > 0; i--) {
                allSorted = true;

                for (int j = 0; j < i; j++) {
                    if (a[j] >= a[j + 1]) continue;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    allSorted = false;
                }
                if(allSorted)break;
            }
        }


    }

    public static void selectSort(int[] a, boolean isAscending){
        if (isAscending) {
            for (int i = 0; i < a.length - 1; i++) {
                int minInd = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[minInd]) {
                        minInd = j;
                    }
                }
                //можно добавить проверку (if minInd!=i)
                int temp = a[i];
                a[i] = a[minInd];
                a[minInd] = temp;
            }
        }else{
            for (int i = 0; i < a.length - 1; i++) {
                int maxInd = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] > a[maxInd]) {
                        maxInd = j;
                    }
                }
                int temp = a[i];
                a[i] = a[maxInd];
                a[maxInd] = temp;
            }
        }

    }




}
