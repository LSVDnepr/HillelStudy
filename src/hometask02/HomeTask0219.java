package hometask02;

import java.util.Random;

public class HomeTask0219 {

    /*
    19.1.Заполнить матрицу из 8 строк и 5 столбцов случайными числами в интервале [-10,10] и вывести ее на экран
    19.2. Найти минимальный и максимальный элементы в матрице и их номера.
    Формат вывода:
    Минимальный элемент: A[3][4]=-6
    Максимальный элемент: A[2][2]=10

    19.3.Вывести на экран строку, сумма элементов которой максимальна.
    Формат вывода
    Строка 2: 3 5 8 9 8
     */

    //19.1
    public static final int ROWS = 8;
    public static final int COLUMNS = 5;


    public static void main(String[] args) {
        int[][] m = new int[ROWS][COLUMNS];
        Random rnd = new Random(75);//delete seed after debug;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                m[i][j] = rnd.nextInt(21) - 10;
            }
        }
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.printf("%6d",m[i][j]);
            }
            System.out.println();
        }

        //19.2 и 19.3

        int minI = 0, minJ = 0;
        int minEl = m[minI][minJ];
        int maxI = 0, maxJ = 0;
        int maxEl = m[maxI][maxJ];

        int maxRowSum=Integer.MIN_VALUE;
        int maxSumRowNum=-1;
        for (int i = 0; i < ROWS; i++) {
            int rowSum=0;
            for (int j = 0; j < COLUMNS; j++) {
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
           // System.out.println("rowSum "+i+" ="+rowSum);
            if (rowSum>maxRowSum){
                maxRowSum=rowSum;
                maxSumRowNum=i;
            }
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
