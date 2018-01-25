package annotationsTask;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Authorization {
    private static Authorization ourInstance = new Authorization();

    public static Authorization getInstance() {
        return ourInstance;
    }

    private Authorization() {
    }


    public boolean isAccessAuthorized(User user, Object obj) {
        if (user == null) throw new NullPointerException("User equals null.Please re-check!");
        if (obj == null) {
            System.out.println("WARNING: Object equals null!");
            return true;
        }

        Class cl = obj.getClass();
        AccessMarker a = (AccessMarker) cl.getAnnotation(AccessMarker.class);
        if (a == null) return true;
        return user.getRoles().contains(a.value());
    }


    public boolean isAccessAuthorized(User user, Field field) {
        if (user == null) throw new NullPointerException("User equals null.Please re-check!");
        if (field == null) throw new NullPointerException("Field equals null.Please re-check!");
        AccessMarker a = (AccessMarker) field.getAnnotation(AccessMarker.class);
        return (a == null || user.getRoles().contains(a.value()));

    }


    public boolean isAccessAuthorized(User user, Method method) {
        if (user == null) throw new NullPointerException("User equals null.Please re-check!");
        if (method == null) throw new NullPointerException("Method equals null.Please re-check!");
        AccessMarker a = method.getAnnotation(AccessMarker.class);
        return (a == null || user.getRoles().contains(a.value()));
    }


    /*printFullAccessInfo
    принимает на вход объект и пользователя:
    печатает есть ли ограничение доступа на класс. и если есть, то какое
    печатает, на какие методы нет ограничений доступа
    на какие методы есть ограничения, но они доступны юзеру
    на какие методы есть ограничения и  они не доступны юзеру, какие роли необходимы для них
    то же с полями
     */

    public void printFullAccessInfo(User user, Object obj) {
        Class cl = obj.getClass();
        printClassAccessInfo(user, cl);
        printAllFieldsAccessInfo(user, cl);
        printAllMethodsAccessInfo(user, cl);

    }

    public void printClassAccessInfo(User user, Object obj) {
        printClassAccessInfo(user, obj.getClass());
    }


    private void printClassAccessInfo(User user, Class cl) {
        AccessMarker marker = (AccessMarker) cl.getAnnotation(AccessMarker.class);
        if (marker == null) {
            System.out.println("\nДоступ к классу не ограничен");
        } else {
            System.out.println("Доступ к классу ограничен");
            if (user.getRoles().contains(marker.value())) {
                System.out.println("Данному пользователю: userId=" + user.getId() + " доступ к классу " + cl.getSimpleName() + " РАЗРЕШЕН");
            } else {
                System.out.println("Данному пользователю: userId=" + user.getId() + " доступ к классу " + cl.getSimpleName() + " ЗАПРЕЩЕН");
                System.out.println("Требуемая роль: " + marker.value());
            }
        }
    }

    public void printAllFieldsAccessInfo(User user, Object obj) {
        printAllFieldsAccessInfo(user, obj.getClass());

    }

    private void printAllFieldsAccessInfo(User user, Class cl) {
        ArrayList<Field> freeAccessF = new ArrayList<>();
        ArrayList<Field> controlledAllowedF = new ArrayList<>();
        HashMap<Field, Roles> fieldsAccessData = new HashMap<>();
        for (Field f : cl.getDeclaredFields()) {
            AccessMarker a = (AccessMarker) f.getAnnotation(AccessMarker.class);
            if (a == null) {
                freeAccessF.add(f);
                continue;
            }
            if (user.getRoles().contains(a.value())) {
                controlledAllowedF.add(f);
                continue;
            }
            fieldsAccessData.put(f, a.value());
        }
        System.out.print("Поля без ограничения доступа: ");
        if (freeAccessF.isEmpty()) {
            System.out.println("отсутствуют");
        } else {
            System.out.println();
            for (Iterator it = freeAccessF.iterator(); it.hasNext(); ) {
                System.out.println("field name=" + ((Field) it.next()).getName());
            }
        }
        int allFieldsCalc = cl.getDeclaredFields().length;
        if (freeAccessF.size() == allFieldsCalc) {
            System.out.println("Поля, c ограниченным доступом, доступные пользователю userId=" + user.getId() + " отсутствуют");
            System.out.println("Поля, c ограниченным доступом, НЕ доступные пользователю userId=" + user.getId() + " отсутствуют");
            return;
        }

        System.out.print("Поля, c ограниченным доступом, доступные пользователю userId=" + user.getId());
        if (controlledAllowedF.isEmpty()) {
            System.out.println(" отсутствуют");
        } else {
            System.out.println();
            for (Iterator it = controlledAllowedF.iterator(); it.hasNext(); ) {
                System.out.println("field name=" + ((Field) it.next()).getName());
            }
        }
        if ((freeAccessF.size() + controlledAllowedF.size()) == allFieldsCalc) {
            System.out.print("Поля, c ограниченным доступом, НЕ доступные пользователю userId=" + user.getId() + " отсутствуют");
            return;
        }
        System.out.print("Поля, c ограниченным доступом, НЕ доступные пользователю userId=" + user.getId());
        System.out.println();
        for (Map.Entry entry : fieldsAccessData.entrySet()) {
            System.out.println("Field name: " + ((Field) entry.getKey()).getName() + ", required role: " + entry.getValue());
        }

    }


    public void printAllMethodsAccessInfo(User user, Object obj) {
        printAllMethodsAccessInfo(user, obj.getClass());
    }


    private void printAllMethodsAccessInfo(User user, Class cl) {
        String methodAccessT1 = "Методы, c ограниченным доступом, доступные пользователю";
        String methodAccessT2 = "Методы, c ограниченным доступом, НЕ доступные пользователю";
        ArrayList<Method> freeAccess = new ArrayList<>(); //Без ограничений доступа
        ArrayList<Method> controlledAllowedM = new ArrayList<>();  //Доступ ограничен, но пользователю разрешен
        HashMap<Method, Roles> controledForbidden = new HashMap<>(); //Доступ ограничен, у пользователя нет прав
        for (Method m : cl.getDeclaredMethods()) {
            AccessMarker marker = (AccessMarker) m.getAnnotation(AccessMarker.class);
            if (marker == null) {
                freeAccess.add(m);
                continue;
            }
            if (user.getRoles().contains(marker.value())) {
                controlledAllowedM.add(m);
                continue;
            }
            controledForbidden.put(m, marker.value());
        }

        System.out.print("Методы без ограничений доступа: ");
        if (freeAccess.isEmpty()) {
            System.out.print(" отсутствуют\n");
        } else {
            System.out.println();
            for (Iterator it = freeAccess.iterator(); it.hasNext(); ) {
                Method m = (Method) it.next();
                System.out.println("Method name= " + m.getName() + " , method args: " + Arrays.toString(m.getParameterTypes()));
            }
        }
        int methodsCalc = cl.getDeclaredMethods().length;
        if (freeAccess.size() == methodsCalc) {
            System.out.println(methodAccessT1 + " userId=" + user.getId() + " отсутствуют");
            System.out.println(methodAccessT2 + " userId=" + user.getId() + " отсутствуют");
            return;
        }

        System.out.print(methodAccessT1 + " userId=" + user.getId());
        if (controlledAllowedM.isEmpty()) {
            System.out.println(" отсутствуют");
        } else {
            System.out.println();
            for (Iterator it = controlledAllowedM.iterator(); it.hasNext(); ) {
                Method m = (Method) it.next();
                System.out.println("Method name=" + m.getName() + " ,method args: " + Arrays.toString(m.getParameterTypes()));
            }
        }
        if ((freeAccess.size() + controlledAllowedM.size()) == methodsCalc) {
            System.out.println(methodAccessT2 + " userId=" + user.getId() + " отсутствуют");
            return;
        }
        System.out.println(methodAccessT2 + "userId=" + user.getId());
        for (Map.Entry entry : controledForbidden.entrySet()) {
            Method m = (Method) entry.getKey();
            System.out.println("Method name=" + m.getName() + ", method args: " + Arrays.toString(m.getParameterTypes()) + ", required role:" + entry.getValue());
        }

    }



}
