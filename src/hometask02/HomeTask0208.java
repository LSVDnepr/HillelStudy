package hometask02;

import java.util.Random;


public class HomeTask0208 {
    /*Задача 8
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в строку.
    Определить и вывести на экран сообщение о том, является ли массив строго возрастающей последовательностью.

     */
    public static void main(String[] args) {
        int[] rndArr=new int[4];
        Random rnd=new Random();//DELETE SEED AFTER DEBUG
        boolean isAscending=true;
        for (int i=0;i<rndArr.length;i++){
            rndArr[i]=rnd.nextInt(90)+10;
            System.out.println(rndArr[i]+" ");
            if (i==0)continue;
            if(rndArr[i]<rndArr[i-1])isAscending=false;
        }

        System.out.println(isAscending?"\nМассив - строго возрастающая последовательность":"\nМассив - НЕ строго возрастающая последовательность");
    }


}
