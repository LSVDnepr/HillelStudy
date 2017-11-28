package hometask02;

import java.util.Random;

public class HomeTask0205 {
    /*Задача 5
    Создайте массив из 15 случайных целых чисел из отрезка [0;9].
    Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов
     и выведете это количество на экран на отдельной строке.
     */

    public static void main(String[] args) {

        //<VARIANT1>
        /*int[] arr=new int[15];
        Random r=new Random(12);//после убрать seed расчета
        for (int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(10);
            System.out.print(arr[i]+" ");
        }
        int evenCalc=0;//СЧИТАТЬ НУЛЬ ЧЕТНЫМ??? ИЛИ ВВЕСТИ ДОП УСЛОВИЕ И ОТСЕИВАТЬ НУЛЬ???
        for (int j:arr){
            if (j%2==0){
                evenCalc++;
            }
        }
        System.out.println("\nВ массиве "+evenCalc+" четных элементов.");*/
        //</VARIANT1>

        //<VARIANT2>
        int[] arr=new int[15];
        int evenCalc=0;//СЧИТАТЬ НУЛЬ ЧЕТНЫМ??? ИЛИ ВВЕСТИ ДОП УСЛОВИЕ И ОТСЕИВАТЬ НУЛЬ???
        Random r=new Random(12);//после убрать seed расчета
        for (int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(10);
            System.out.print(arr[i]+" ");
            if (arr[i]%2==0) evenCalc++;
        }
        System.out.println("\nВ массиве "+evenCalc+" четных элементов.");
        //</VARIANT2>


    }





}
