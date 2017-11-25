package hometask01;

public class HomeTask0104 {
    /*Задание 4
  Определить, является ли число а делителем числа b и c одновременно (делится без остатка)
     */
    public static void main(String[] args) {
        int a=23, b=345,c=1035;

        if((b%a==0)&&(c%a==0)){
            System.out.println("ДА, число "+a+" является одновременно делителем числа "+b+" и числа "+c);
        return;
        }
        System.out.println("НЕТ, число "+a+" НЕ является одновременно делителем числа "+b+" и числа "+c);
    }

}
