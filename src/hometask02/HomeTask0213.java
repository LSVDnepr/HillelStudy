package hometask02;

import java.util.Random;

public class HomeTask0213 {
    /*Задача 13
    Заполнить массив из 10 элементов случайными числами в интервале [0..100] и отсортировать по последней цифре.
    Пример:
    Исходный массив:
    14 25 13 30 76 58 32 11 41 97
    Результат:
    30 11 41 32 13 14 25 76 97 58
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random(75);//delete seed after debug
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println("Исходный массив: ");
        for (int el : arr) {
            System.out.print(el + " ");
        }

        //выполняю сортировку выбором по последней цифре
        for (int i = 0; i < arr.length - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                //сравниваю последние цифры элементов
                if (arr[j] % 10 < arr[minInd] % 10) {
                    minInd = j;
                    continue;
                }
                //Если последние цифры равны, сравниваю предпоследние
                if (arr[j] % 10 == arr[minInd] % 10) {
                    if (((arr[j] / 10) % 10) < (arr[minInd] / 10) % 10) {
                        minInd = j;
                    }
                }

            }
            //меняю местами
            if (minInd != i) {
                int temp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = temp;
            }

        }
        System.out.println("\nРезультат: ");
        for (int el : arr) {
            System.out.print(el + " ");
        }


    }

    /*Скорректировать решение на возможность сравнивать 2,3,4,...-значные числа по цифрам с учетом разного кол-ва цифр в числах
    например
    1001 и 101
    7752 и 52 и т.д.


     */


}
