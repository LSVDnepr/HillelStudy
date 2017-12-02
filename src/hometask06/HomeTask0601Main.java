package hometask06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HomeTask0601Main {

    /*
    Создать несколько собственных исключений, как checked так и unchecked, для нескольких возможных логических ошибок:
    1)в программе должны перебрасываться через метод без обработки - для checked
    2)обработка в блоке try с логическим завершением
    3)должен присутствовать блок finally
    4)попробовать написать return в finally и описать результат

     */


    //1) в программе должны перебрасываться через метод без обработки - для checked

    public static void method1() throws MyFileNotFoundException {
        try {
            File f = new File("C://someDirectory//someFile.txt");
            FileReader fr = new FileReader(f);
            System.out.println(f.getName());
        } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException("Couldn't find the file",e);
        }
    }

    //2,3,4
    public static String method2(String s) {
        String message = "All is Ok";
        try {
            if (s.equals("input trouble")) {
                throw new MyIOException("The input trouble has occurred");
            }
            if (s.equals("invalid data")) {
                throw new MyRuntimeException("Provided data is not correct");
            }
            System.out.println("TRY message of method2 is: " + message);
            return message;
        } catch (MyIOException e) {
            System.out.println("My IO Exception has been handled");
            message = "Program execution has been terminated due to exceptions";
            System.out.println("CATCH message of method2 is: " + message);
            return message;

        } catch (MyRuntimeException r) {
            System.out.println("MyRuntimeException has been handled");
        } finally {
            message = "I have overwritten the response of all blocks.";
            System.out.println("FINALLY message of method2 is: " + message);
            return message;
        }
    }



    public static String method3(String s) throws MyIOException {
        String result = "";
        try {
            if (s.isEmpty()) throw new MyIOException("incorrect input");
            result = method2(s);
        } finally {
            if (!result.equals("All is Ok")) return result+"@try-finally";
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("Method 1");
        try {
            method1();
        } catch (MyFileNotFoundException e) {
            System.out.println("MyFileNotFoundException was handled in main");
        }
        System.out.println("Method 2");

        System.out.println("Final result of method 2: " + method2("input trouble") + "\n***");
        System.out.println("Final result of method 2: " + method2("invalid data") + "\n***");
        System.out.println("Final result of method 2: " + method2("correct string") + "\n***");

        System.out.println("Method 3");
        try {
            System.out.println("Final result of method 3: " + method3("") + "\n***");
            System.out.println("Final result of method 3: " + method3("input trouble") + "\n***");
        } catch (MyIOException e) {
            System.out.println("Method 3: My IO exception was handled in main");
        }

    }


}
