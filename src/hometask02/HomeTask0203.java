package hometask02;

public class HomeTask0203 {
    /* Задача 3
    Создайте массив из всех чётных чисел от 2 до 20 и
    выведите элементы массива на экран сначала в строку, отделяя один элемент от другого пробелом,
    а затем в столбик (отделяя один элемент от другого началом новой строки).
    Перед созданием массива подумайте, какого он будет размера.
     */

    public static void main(String[] args) {
        int[] even=new int[10];

        //<VARIANT 1>
        /*for (int i=0;i<even.length;i++){
            even[i]=(i+1)*2;
        }*///</VARIANT1>

        //<VARIANT2>
        for (int i=0,j=2;i<even.length;i++,j+=2){
            even[i]=j;
        }
        //</VARIANT2>


        //<VARIANT3>//НЕ НРАВИТСЯ ЭТОТ ВАРИАНТ
        int j=1;
        for (int i=0;i<even.length;) {
            if (j % 2 == 0) {
                even[i] = j;
                i++;
            }
            j++;
        }
        //</VARIANT3>

        for (int i:even){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i:even){
            System.out.print(i+"\n");
        }

    }



}
