package hometask07;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> strList=new MyArrayList<>(5);
        strList.add("word1");
        strList.add("word2");
        strList.add("word3");
        System.out.println("Заполненный arrayList:");
        System.out.println(strList);
        strList.add(1,"word4");
        System.out.println("После добавления элемента на индекс 1: ");
        System.out.println(strList);
        strList.add("word5");
        strList.add("word6");
        strList.add("word7");
        strList.remove("word4");
        strList.add(3,"word4");
        System.out.println("После добавления новых элементов, удаления элемента word4 c индекса 1 и вставки этого элемента на индекс 3");
        System.out.println(strList);


        MyArrayList<Integer> intList=new MyArrayList<>();
        for (int i=0;i<15;i++){
            intList.add(i*2);
        }

        intList.add(4,5);
        intList.add(8,7);
        intList.add(1,11);
        intList.add(10,17);

        System.out.println(intList);

        for (int i=0;i<intList.size();i++){
            if (intList.get(i)%2==0){
                intList.remove(i);
                i--;
            }

        }
        System.out.println("После удаления четных элементов: ");
        System.out.println(intList);



    }
}
