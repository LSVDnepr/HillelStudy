package hometask02;

import java.util.Random;
import java.util.Scanner;

public class HomeTask0217 {
    /*
    Написать программу, которая сортирует массив ПО УБЫВАНИЮ и
    ищет в нем элемент, равный Х (это число вводится с клавиатуры).
     */

    public static void main(String[] args) {
        int[] ar = new int[27];
        Random r = new Random(757);//delete seed later
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(27);
        }

        for (int el : ar) {
            System.out.print(el + " ");
        }
        System.out.println();
        sortArray(ar, false);

        for (int el : ar) {
            System.out.print(el + " ");
        }
        System.out.println();

        System.out.println("Введите искомое число");
        int searchNum = new Scanner(System.in).nextInt();
        System.out.println("Ваше число: " + searchNum);
      // binarySearch(searchNum, ar, 0, (ar.length - 1));
        //int ind=(ar[0]==searchNum?1:(ar[ar.length-1]==searchNum)?(ar.length-1):(binarySearch2(searchNum, ar, 0, ar.length - 1,true)));

        //int ind=binarySearch(searchNum, ar, 0, ar.length - 1,true);
       // System.out.println("Индекс искомого элемента="+ind);
        //binarySearch2(searchNum, ar, 0, ar.length - 1,true);
       int ind=binarySearch(searchNum, ar, 0, ar.length - 1, true,false);
        System.out.println("Индекс искомого элемента="+ind);


    }


    public static void sortArray(int[] a, boolean isAscending) {
        //реализую сортировку методом bubble sort with flag
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
                if (allSorted) break;

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
                if (allSorted) break;
            }
        }

    }


    public static int binarySearch(int num, int[] a, int left, int right) {

        //проверить корректно ли указан диапазон (левая граница меньше правой)

        //Проверить может ли данный элемент быть в этом диапазоне (не выходит ли за граничные значения)

        //прорабоать кейс, когда осталось только 2 элемента

        //проработать кейс, когда нечетное количество элементов в массиве

        //Проработать кейс, когда есть несколько одинаковых значений в диапазоне. тогда установить какой именно из элементнов
        //нам нужен, первый, последний, любой.


        if (left > right) {
            System.out.println("Указан несуществующий диапазон");
            return -1;
        }


        if (left + 1 == right) {
            if ((a[left] == num)) {
                return left;
            }
            if (a[right] == num) {
                return right;
            }
            System.out.println("Элемент не найден");
            return -1;

           /* if ((a[left]!=num)&&(a[right]!=num)){
                System.out.println("Массив пройден, элемент не найден");
                return -1;
            }
            */

        }


        if ((num > a[left]) || (num < a[right])) {
            System.out.println("Данного числа нет в заданном массиве");
            return -1;
        }
        //Проверить на равенство на граничных индексах??

        int middle = (left + right) / 2;
        if (num == a[middle]) {
           // System.out.println("Индекс искомого элемента=" + middle);
            return middle;
        }
        if (num > a[middle]) {
            right = middle;
        } else {
            left = middle;
        }
        return binarySearch(num, a, left, right);


    }


    public static int binarySearch(int num, int[] a, int left, int right, boolean isAscending) {

        //Проработать кейс, когда есть несколько одинаковых значений в диапазоне. тогда установить какой именно из элементнов
        //нам нужен, первый, последний, любой.
        //Проверить на равенство на граничных индексах??
       // System.out.println("left border="+left);
      //  System.out.println("right border="+right);
       // System.out.println("looking for element="+num);

        if (left > right) {
            System.out.println("Указан несуществующий диапазон");
            return -1;
        }

        if (left + 1 == right) {
            if ((a[left] == num)) {
                return left;
            }
            if (a[right] == num) {
                return right;
            }
            System.out.println("Элемент не найден");
            return -1;
        }

        if (isAscending) {
            if ((num < a[left]) || (num > a[right])) {
                System.out.println("Данного числа нет в заданном массиве");
                return -1;
            }
            //Проверить на равенство на граничных индексах??

            int middle = (left + right) / 2;
            if (num == a[middle]) {
                //System.out.println("Индекс искомого элемента=" + middle);
                return middle;
            }
            if (num < a[middle]) {
                right = middle;
            } else {
                left = middle;
            }

        } else {
            if ((num > a[left]) || (num < a[right])) {
                System.out.println("Данного числа нет в заданном массиве");
                return -1;
            }
            //Проверить на равенство на граничных индексах??

            int middle = (left + right) / 2;
            if (num == a[middle]) {
                System.out.println("Индекс искомого элемента=" + middle);
                return middle;
            }
            if (num > a[middle]) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return binarySearch(num, a, left, right,isAscending);

    }



    public static int binarySearch(int num, int[] a, int left, int right, boolean showFirst,boolean isAscending) {

        //Проработать кейс, когда есть несколько одинаковых значений в диапазоне. тогда установить какой именно из элементнов
        //нам нужен, первый, последний, любой.
        //Проверить на равенство на граничных индексах??
       /* System.out.println("left border="+left);
        System.out.println("right border="+right);
        System.out.println("looking for element="+num);*/

        if (left > right) {
            System.out.println("Указан несуществующий диапазон");
            return -1;
        }

        if (left + 1 == right) {//прописать поиск нужного из найденных элементов??
            if ((a[left] == num)) {
                return left;
            }
            if (a[right] == num) {//прописать поиск нужного из найденных элементов??
                return right;
            }
            System.out.println("Элемент не найден");
            return -1;
        }

        if (isAscending) {//Если диапазон поиска отсортирован ПО ВОЗРАСТАНИЮ
            if ((num < a[left]) || (num > a[right])) {
                System.out.println("Данного числа нет в заданном массиве");
                return -1;
            }
            //Проверить на равенство на граничных индексах??

            int middle = (left + right) / 2;
            if (num == a[middle]) {
                if (showFirst){
                    //int ind=middle;
                    System.out.println("middleStart="+middle);
                    while (middle>0){
                        if (a[middle-1]==num) {
                            middle--;
                        }else{
                            break;
                        }
                        //ПРОВЕРИТЬ, ЧТОБЫ ПРИ ЭТОМ ИНДЕКС НЕ БЫЛ МЕНЬШЕ НУЛЯ ИЛИ БОЛЬШЕ ПОСЛЕДНЕГО ИНДЕКСА В МАССИВЕ
                        System.out.println("Предыдущий элемент тоже равен искомому");

                    }
                    System.out.println("middle="+middle);
                    //return ind;
                }else{
                    //int ind=middle;
                    System.out.println("middleStart="+middle);
                    while (middle<a.length-1){
                        if (a[middle+1]==num){
                            middle++;
                        }else{
                            break;
                        }
                        System.out.println("Следующий элемент тоже равен искомому");
                    }
                    System.out.println("middle="+middle);

                }
                return middle;
                //System.out.println("Индекс искомого элемента=" + middle);
              //  return middle;
            }
            if (num < a[middle]) {
                right = middle;
            } else {
                left = middle;
            }

        } else {//Если диапазон поиска отсортирован ПО УБЫВАНИЮ
            if ((num > a[left]) || (num < a[right])) {
                System.out.println("Данного числа нет в заданном массиве");
                return -1;
            }
            //Проверить на равенство на граничных индексах??

            int middle = (left + right) / 2;
            if (num == a[middle]) {
                if (showFirst){
                    //int ind=middle;
                    System.out.println("middleStart="+middle);
                    while (middle>0){
                        if (a[middle-1]==num) {
                            middle--;
                        }else{
                            break;
                        }
                        //ПРОВЕРИТЬ, ЧТОБЫ ПРИ ЭТОМ ИНДЕКС НЕ БЫЛ МЕНЬШЕ НУЛЯ ИЛИ БОЛЬШЕ ПОСЛЕДНЕГО ИНДЕКСА В МАССИВЕ
                        System.out.println("Предыдущий элемент тоже равен искомому");

                    }
                    System.out.println("middle="+middle);
                    //return ind;
                }else{
                    //int ind=middle;
                    System.out.println("middleStart="+middle);
                    while (middle<a.length-1){
                        if (a[middle+1]==num){
                            middle++;
                        }else{
                            break;
                        }
                        System.out.println("Следующий элемент тоже равен искомому");
                    }
                    System.out.println("middle="+middle);

                }
                return middle;
            }
            if (num > a[middle]) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return binarySearch(num, a, left, right,showFirst,isAscending);

    }


}
