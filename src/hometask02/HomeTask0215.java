package hometask02;

import java.util.Random;

public class HomeTask0215 {
    /*Задача 15
   15.1 Найти минимальный и максимальный элементы в матрице и их номера.
    Формат вывода:
    Минимальный элемент: A[3][4]=-6
    Максимальный элемент: A[2][2]=10

    15.2 Вывести на экран строку, сумма элементов которой максимальна.
Формат вывода
Строка 2: 3 5 8 9 8


     */

    public static final int ROWS = 7;
    public static final int COLUMNS = 9;


    public static void main(String[] args) {
        int[][] m = new int[ROWS][COLUMNS];
        Random rnd = new Random(75);//delete seed after debug;

        int minI = 0;
        int minJ = 0;
        int minEl = m[minI][minJ];
        int maxI = 0;
        int maxJ = 0;
        int maxEl = m[maxI][maxJ];

        int maxRowSum=Integer.MIN_VALUE;
        int rowSum=0;
        int maxSumRowNum=-1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                m[i][j] = rnd.nextInt(21) - 10;
                if (m[i][j] < minEl) {
                    minI = i;
                    minJ = j;
                    minEl = m[i][j];
                }
                if (m[i][j] > maxEl) {
                    maxI = i;
                    maxJ = j;
                    maxEl = m[i][j];
                }
                rowSum+=m[i][j];
            }
            System.out.println("Сумма элементов строки "+i+"="+rowSum);
            if (rowSum>maxRowSum){
                System.out.println("Найден новый максимум в строке"+i+" по сумме="+rowSum+" по сравнению с прежним максимумом="+maxRowSum+" в строке "+maxSumRowNum);
                maxRowSum=rowSum;
                maxSumRowNum=i;
            }
        }

        System.out.println("Итоговая матрица");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("Строка " + i + "  :");
            for (int j = 0; j < COLUMNS; j++) {
                int num = m[i][j];
                //System.out.print(((num >= 0) && (num < 10)) ? "\t   " + num : ((((num >= -9) && (num < 100)) ? ("\t  " + num) : ("\t " + num))));
                System.out.printf("%5d",m[i][j]);


            }
            System.out.println();

        }
        System.out.println("Минимальный элемент: m[" + minI + "][" + minJ + "]=" + minEl);
        System.out.println("Максимальный элемент: m[" + maxI + "][" + maxJ + "]=" + maxEl);
        System.out.println("Строка, сумма элементов которой максимальна: ");
        System.out.print("Строка "+maxSumRowNum+": ");
        for (int i=maxSumRowNum, j=0;j<COLUMNS;j++){
            System.out.print(m[i][j]+" ");
        }
        System.out.println("\nМаксимальная сумма="+maxRowSum);


    }


}
