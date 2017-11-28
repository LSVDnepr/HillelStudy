package hometask02;

import java.util.Random;

public class HomeTask0207 {
    /*Задача 7
    Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
    выведите массивы на экран в двух отдельных строках.
    Посчитайте среднее арифметическое элементов каждого массива и сообщите,
    для какого из массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны).

     */


    public static void main(String[] args) {
        int[] ar1=new int[5];
        int[] ar2=new int[5];
        Random rnd=new Random(757);//DELETE SEED AFTER COMPLETING TESTS
        int ar1Sum=0, ar2Sum=0;
        //<VARIANT 1> без оптимизаций и четко пошагово

        for (int i=0;i<ar1.length;i++){
            ar1[i]=rnd.nextInt(6);
            System.out.print(ar1[i]+" ");
            ar1Sum+=ar1[i];
        }

        double avr1=(double) ar1Sum/ar1.length;
        System.out.println();


        for (int i=0;i<ar2.length;i++){
            ar2[i]=rnd.nextInt(6);
            System.out.print(ar2[i]+" ");
            ar2Sum+=ar2[i];
        }

        double avr2=(double) ar2Sum/ar2.length;
        System.out.println();

        if (avr1==avr2) {
            System.out.println("Средние арифметичекие элементов массивов равны: "+avr1+"="+avr2);
            return;
        }
        if (avr1>avr2){
            System.out.println("Среднее арифметическое элементов первого массива больше: "+avr1+">"+avr2);
        }else{
            System.out.println("Среднее арифметическое элементов второго массива больше: "+avr2+">"+avr1);
        }

        //</VARIANT 1>

        //<VARIANT2>
        /*int[] ar1=new int[5], ar2=new int[5];
        Random rnd=new Random(757);//DELETE SEED AFTER COMPLETING TESTS
        int ar1Sum=0, ar2Sum=0;

        for (int i=0;i<ar1.length;i++){
            ar1[i]=rnd.nextInt(6);
            ar1Sum+=ar1[i];
            ar2[i]=rnd.nextInt(6);
            ar2Sum+=ar2[i];
        }
        for (int i:ar1){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int j:ar2){
            System.out.print(j+" ");
        }
        System.out.println();
        double avr1=(double) ar1Sum/ar1.length;
        double avr2=(double) ar2Sum/ar2.length;

        if (avr1==avr2) {
            System.out.println("Средние арифметичекие массивов равны: "+avr1+"="+avr2);
            return;
        }
        if (avr1>avr2){
            System.out.println("Среднее арифметическое первого массива больше: "+avr1+">"+avr2);
        }else{
            System.out.println("Среднее арифметическое второго массива больше: "+avr2+">"+avr1);
        }

        //можно решить тернарником, со вторым вложенным тернарником, но строки слишком громоздкие либо надо создавать три
        //переменных String и в ним помещать значения...*/

        //</VARIANT2>

    }
}
