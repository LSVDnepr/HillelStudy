package hometask01;

public class HomeTask0117 {

    /*Задача 17
    Вывести на экран фигуру (елочка)*/

    public static void main(String[] args) {


//<variant 1>
        int width=19;
        for (int star=1;star<=width;star+=2){
            for (int i=0;i<width;i++){
                int indent=(width-star)/2;
                System.out.print(((i>=indent)&&(i<indent+star))?"*":" ");
                // System.out.print(((i>=(width-star)/2)&&(i<(width+star)/2))?"*":" ");
            }
            System.out.println();
        }
       //</variant1>

      //<variant2>
       /*int width=19;
        int star=1;
        //int indent=(width-star)/2;
        while (star<=width){
            for (int indent=(width-star)/2;indent>0;indent--){
                System.out.print(" ");
            }
            for (int n=0;n<star;n++) {
                System.out.print("*");
            }
            System.out.println();
            star+=2;
        }*/
      //</variant2>

    }

}
