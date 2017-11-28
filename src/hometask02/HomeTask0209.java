package hometask02;

import java.util.Random;

public class HomeTask0209 {

    /*Задача 9
    Заполнить массив из 10 элементов случайными числами в интервале [-10..10] и выполнить циклический сдвиг ВПРАВО.

     */

    public static void main(String[] args) {
        int[] a=new int[10];
        Random rnd=new Random(555);//delete seed after debug
        for (int i=0;i<a.length;i++){
            a[i]=rnd.nextInt(21)-10;
            System.out.print(a[i]+" ");
        }
        System.out.println();

        int temp=a[a.length-1];

        for (int i=a.length-1;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=temp;

        for (int el:a){
            System.out.print(el+" ");
        }

    }


}
