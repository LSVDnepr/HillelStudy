package hometask02;

public class HomeTask0204 {
    /* Задача 4
    2.	Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
     а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1).

     */

    public static void main(String[] args) {
        int[] odd=new int[50];

       /*//<VARIANT1>
        for (int i=0,j=1;i<odd.length;i++,j+=2){
            odd[i]=j;
        }*/

        //</VARIANT1>

        //<VARIANT2>//больше нравится вариант 1
        int j=1;
        for (int i=0;i<odd.length;i++){
            odd[i]=j;
            j+=2;
        }

        //</VARIANT2>

        for (int i:odd){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=odd.length-1;i>=0;i--){
            System.out.print(odd[i]+" ");
        }

    }

}
