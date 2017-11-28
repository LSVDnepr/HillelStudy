package hometask02;

import java.util.Random;

public class HomeTask0214 {
    public static final int ROWS = 8;
    public static final int COLUMNS = 5;

    /* Задача 14
    Заполнить матрицу из 8 строк и 5 столбцов случайными числами в интервале [-10,10] и вывести ее на экран
     */
    public static void main(String[] args) {
        int[][] m = new int[ROWS][COLUMNS];
        Random rnd = new Random(75);//delete seed after debug;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                m[i][j] = rnd.nextInt(21) - 10;
            }
        }
        System.out.println("Итоговая матрица");
        for (int i = 0; i < ROWS; i++) {
           // System.out.print("Строка "+i+"  :");
            for (int j = 0; j < COLUMNS; j++) {
                //System.out.print(m[i][j]>=0?("   "+m[i][j]):("  "+m[i][j]));
                //System.out.print((m[i][j]>=0?"   ":"  ")+m[i][j]);
                //System.out.print("\t\t"+m[i][j]);
                //<VARIANT OF PRINT 1>
                /*int num = m[i][j];
                if ((num>=0)&&(num<10)){
                    System.out.print("\t   "+num);
                }else {
                    if ((num>=-9)&&(num<100)) {
                        System.out.print("\t  " + num);
                    }else{
                        System.out.print("\t "+num);
                    }
                }*/
                //</VARIANT OF PRINT 1>

                //<VARIANT OF PRINT 2>
                int num = m[i][j];

                //System.out.print(((num>=0)&&(num<10))?"\t   "+num:((((num>=-9)&&(num<100))?("\t  " + num):("\t "+num))));//ВАЛИДНЫЙ КОД, НУЖЕН ВМЕСТО PRINT F
                System.out.printf("%6d",m[i][j]);


                //</VARIANT OF PRINT 2>


            }
            System.out.println();
        }

    }


}
