package hometask02;

import java.util.Random;

public class HomeTask0206 {

    /*Задача 6
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран в строку.
    Замените каждый элемент с нечетным индексом на ноль. Снова выведете массив на экран на отдельной строке.

     */

    public static void main(String[] args) {
        int[] ar=new int[8];
        Random rnd=new Random(15); //УДАЛИТЬ seed!!! ПОСЛЕ ТЕСТОВ

        //<VARIANT 1> четко по условию, пошагово, никакого объединения этапов решения и оптимизаций
        /*for (int i=0;i<ar.length;i++){
            ar[i]=rnd.nextInt(10)+1;
        }
        for (int j:ar){
            System.out.print(j+" ");
        }
        System.out.println();

        for (int i=0;i<ar.length;i++){
            if (i%2!=0){
                ar[i]=0;
            }
        }
        for (int j:ar){
            System.out.print(j+" ");
        } */

        //</VARIANT1>

        //<VARIANT2>
        for (int i=0;i<ar.length;i++){
            ar[i]=rnd.nextInt(10)+1;
            System.out.print(ar[i]+" ");
            if(i%2!=0)ar[i]=0;
        }
        System.out.println();
        for (int j:ar){
            System.out.print(j+" ");
        }
        //</VARIANT2>


    }
}
