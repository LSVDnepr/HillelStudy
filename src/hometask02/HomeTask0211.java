package hometask02;

import java.util.Random;

public class HomeTask0211 {
    /*Задача 11
    Заполнить массив из 10 элементов случайными числами в интервале [-10..10] и
    выполнить инверсию отдельно для 1-ой и 2-ой половин массива.
    Пример:
Исходный массив:
  4 -5 3 10 -4  -6 8 -10 1 0

Результат:
 -4 10 3 -5 4   0 1 -10 8 -6
     */

    public static void main(String[] args) {
        int[] a=new int[10];
        Random r=new Random(25);//Удалить seed после дебага
        for (int i=0;i<a.length;i++){//заполняю массив
            a[i]=r.nextInt(21)-10;
            if (i==a.length/2){
                System.out.print("   ");
            }
            System.out.print(a[i]+" ");
        }

        //System.out.println("\nВыполняю инверсию первой половины массива");
        for (int i=0;i<a.length/4;i++){
            int temp=a[i];
            a[i]=a[a.length/2-1-i];
            a[a.length/2-1-i]=temp;
        }

        /*System.out.println("\nРезультат: ");
        for (int i=0;i<a.length;i++){
            if (i==a.length/2){
                System.out.print("   ");
            }
            System.out.print(a[i]+" ");
        }*/

       // System.out.println("\nВыполняю инверсию второй половины массива");
        int j=a.length-1;
        for (int i=a.length/2;i<3*a.length/4;i++){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            j--;
        }

        System.out.println("\nРезультат: ");
        for (int i=0;i<a.length;i++){
            if (i==a.length/2){
                System.out.print("   ");
            }
            System.out.print(a[i]+" ");
        }
    }

}
