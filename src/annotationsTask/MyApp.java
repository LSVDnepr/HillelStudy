package annotationsTask;



import java.lang.reflect.Method;
import java.util.Arrays;


public class MyApp {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        User user1 = new User(12345, Arrays.asList(new Roles[]{Roles.DEV}));
        //System.out.println(user1.getRoles());
        User user2 = new User(777721, Arrays.asList(new Roles[]{Roles.QA}));
        User user3 = new User(454521, Arrays.asList(new Roles[]{Roles.SUPPORT}));
        User user4 = new User(1111, Arrays.asList(new Roles[]{Roles.ADMIN}));
        //System.out.println(Authorization.getInstance().isAccessAuthorized(user1, test1) ? "Доступ разрешен" : "Доступ запрещен");
        //System.out.println(Authorization.getInstance().isAccessAuthorized(user4, test1) ? "Доступ разрешен" : "Доступ запрещен");
        /*printAuthorizationCheck(user1,test1);
        printAuthorizationCheck(user4,test2);
        printAuthorizationCheck(user2,test1);
        printAuthorizationCheck(user3,test1);
        printAuthorizationCheck(user2,test2);*/

      Authorization.getInstance().printFullAccessInfo(user3,test1);
        //Authorization.getInstance().printFullAccessInfo(user1,test2);
        //Authorization.getInstance().printAllMethodsAccessInfo(user1,test1);
        Authorization.getInstance().printFullAccessInfo(user4,test1);


        Class cl= test2.getClass();
        try {
            System.out.println(Authorization.getInstance().isAccessAuthorized(user1,cl.getDeclaredField("field1"))?"Доступ разрешен" : "Доступ запрещен");

        }catch (NoSuchFieldException ex){
            System.out.println("No such field found!");
            //ex.printStackTrace();
        }


        try {
            Method method=cl.getDeclaredMethod("method1",new Class[]{int.class});
            System.out.println(Authorization.getInstance().isAccessAuthorized(user2,method)?"Доступ разрешен" : "Доступ запрещен");

        }catch (NoSuchMethodException ex){
            System.out.println("No such method found!");
           // ex.printStackTrace();
        }

    }

    public static void printAuthorizationCheck(User user,Object obj){
        System.out.print(Authorization.getInstance().isAccessAuthorized(user, obj) ? "Доступ разрешен:" : "Доступ запрещен:");
        System.out.println(" userId="+user.getId()+",\tclass="+obj.getClass().getSimpleName());
    }




}
