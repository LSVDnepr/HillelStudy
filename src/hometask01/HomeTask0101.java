package hometask01;

public class HomeTask0101 {
    /*
    Задание 1
    Вывести на экран текст «лесенкой»:
    Фамилия
	    Отчество
			    Имя


     */
    public static void main(String[] args) {
      String[] data={"Litovchenko","Victorovna","Svetlana"};
        for (int i=0;i<data.length;i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(data[i]);
        }
    }
}
