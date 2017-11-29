package hometask03;

public class HomeTask0306Static {
    static int a=3;
    static  int b;
    static void method(int x){
        System.out.println("x= "+ x);
        System.out.println("a= " +a);
        System.out.println("b="+b);

    }
    {
        System.out.println("block initialized");
    }

    static {
        System.out.println("static block initialized");
        b=a*4;
    }


    HomeTask0306Static(){
        System.out.println("constructor has been executed");
    }

    public static void main(String[] args) {
        method(42);
        HomeTask0306Static c=new HomeTask0306Static();
    }



}
