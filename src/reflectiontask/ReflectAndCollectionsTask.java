package reflectiontask;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;


public class ReflectAndCollectionsTask {

    /* ЗАДАНИЕ
    1. Создать через отражение экземпляр класса HashMap
 1.1. Добавить несколько элементов одного типа
 1.2. Получить элементы и вывести на экран
 1.3. Проверить, что экземпляр является тем, который мы ожидаем.
 1.4. Вывести на экран родительский класс класса HashMap
 1.5. Вывести реализуемые интерфейсы классом HashMap
2. Вывести на экран все открытые методы и поля класса  ArrayList
 2.1. Вывести на экран все скрытые данные(поля) класса ArrayList
 3. Создать свой класс с приватным полем и публичным.
	3.1. Динамически изменить значение приватного поля.
	3.2. Все вывести на экран.(оба типа полей до и после модификации)
4. Получить ошибку ClassCastException

     */

    public static void main(String[] args) throws Exception {

        System.out.println("ЗАДАНИЕ 1");
        //1. Создать через отражение экземпляр класса HashMap
        Class mapClass = Class.forName("java.util.HashMap");
        //HashMap<Integer, String> reflectMap = (HashMap<Integer, String>) mapClass.getConstructor().newInstance();
        // 1.3. Проверить, что экземпляр является тем, который мы ожидаем.

        HashMap<Integer, String> reflectMap = null;
        Object obj = mapClass.getConstructor().newInstance();
        if (obj instanceof HashMap) {
            System.out.println("Объект соответствует ожидаемому типу");
            reflectMap = (HashMap) obj;
        } else {
            System.out.println("Полученный экземпляр не соответствует ожидаемому типу");
        }

        //1.1. Добавить несколько элементов одного типа (В смысле String/String??)
        reflectMap.put(1, "Introduction");
        reflectMap.put(2, "Arrays");
        reflectMap.put(3, "Functions, Classes, Packages");
        reflectMap.put(4, "Nested Classes, Functional Interfaces");
        reflectMap.put(5, "String, StringBuffer, StringBuilder");
        reflectMap.put(6, "Exceptions");
        reflectMap.put(7, "VCS");
        reflectMap.put(8, "Java Collections");
        reflectMap.put(9, "Generics");
        reflectMap.put(10, "Multithreading");

        //1.2. Получить элементы и вывести на экран
        for (Map.Entry<Integer, String> entry : reflectMap.entrySet()) {
            System.out.println("Lesson №" + entry.getKey() + " topic : " + entry.getValue());
        }

        //1.4. Вывести на экран родительский класс класса HashMap
        System.out.println("Родительский класс для класса HashMap: " + mapClass.getSuperclass());

        //1.5. Вывести реализуемые интерфейсы классом HashMap
        System.out.println("Класс HashMap реализует следующие интерфейсы: ");
        for (Class cInterface : mapClass.getInterfaces()) {
            System.out.println(cInterface.getName());
        }

    //4. Получить ошибку ClassCastException
        try {
            mapClass = (Class) obj;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        System.out.println("ЗАДАНИЕ 2");
        // 2 Вывести на экран все открытые методы и поля класса  ArrayList
        Class arrayListClass = Class.forName("java.util.ArrayList");
        System.out.println("Public methods of java.util.ArrayList: \n***********");

        for (Method m : arrayListClass.getMethods()) {
            System.out.println(getMethodFullInfo(m));
        }

        System.out.println("\nPublic fields of java.util.ArrayList\n***********");
        for (Field f : arrayListClass.getDeclaredFields()) {
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
        }

        // 2.1. Вывести на экран все скрытые данные(поля) класса ArrayList
        System.out.println("\nAll non-public methods of java.util.ArrayList\n***********");
        for (Method m : arrayListClass.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) continue;
            System.out.println(getMethodFullInfo(m));
        }

        System.out.println("\nAll non-public fields of java.util.ArrayList\n***********");
        for (Field f : arrayListClass.getDeclaredFields()) {
            if (Modifier.isPublic(f.getModifiers()))
                continue;//игнорирую public поля, анализирую только package, protected, private
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
        }


        System.out.println("ЗАДАНИЕ 3");
        //Как создать другой класс, чтобы в нем выполнять всю работу по UserData??
        System.out.println("\n");

        UserData ud = new UserData("lana", "root", "root");
        System.out.println(ud);
        Class udCl = ud.getClass();
        for (Field f : udCl.getDeclaredFields()) {
            if (Modifier.isPublic(f.getModifiers())) {
                System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
            }else{

                //f.setAccessible(true);
                System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());

            }
        }
        for (Method m : udCl.getDeclaredMethods()) {
            System.out.println(getMethodFullInfo(m));
        }

        System.out.println("Fields before modification: ");
        Method userFulInfo=udCl.getDeclaredMethod("getFullInfo");
        userFulInfo.setAccessible(true);
        System.out.println(userFulInfo.invoke(ud));

        System.out.println("Fields after modification");
        ud.setNameToShow("Sveta");
        Field login=udCl.getDeclaredField("login");
        login.setAccessible(true);
        login.set(ud,"admin");

        Field password=udCl.getDeclaredField("password");
        password.setAccessible(true);
        password.set(ud,"12345");


        //вручную получаю значения каждого поля и вывожу в консоль:
        for (Field f:udCl.getDeclaredFields()){
            if (!Modifier.isPublic(f.getModifiers()))f.setAccessible(true);
            System.out.println(f.getName()+"="+f.get(ud));
        }


    }


    public static String getMethodFullInfo(Method m) {
        StringBuilder sb = new StringBuilder(100);
        sb.append(Modifier.toString(m.getModifiers())).append(" ").append(m.getReturnType().getSimpleName()).append(" ").append(m.getName()).append(" ");
        if (m.getParameters().length == 0) {
            sb.append("( )");
        } else {
            sb.append("(");
            for (Parameter p : m.getParameters()) {
                sb.append(p.getType().getSimpleName()).append(" ").append(p.getName()).append(", ");
            }
            sb.append("\b\b)");
        }
        return sb.toString();
    }



}
