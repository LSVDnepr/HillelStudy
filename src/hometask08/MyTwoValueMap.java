package hometask08;

import java.util.*;
import java.util.function.BiPredicate;

import static hometask08.MyTwoValueMap.ValueStorage;

public class MyTwoValueMap<K, V1, V2> extends HashMap<K, ValueStorage<V1, V2>> {

    public V1 getValue1(K key) {
        MyTwoValueMap.ValueStorage<V1, V2> vs = get(key);
        return (vs != null ? vs.getValue1() : null);
    }

    public V2 getValue2(K key) {
        MyTwoValueMap.ValueStorage<V1, V2> vs = get(key);
        return (vs != null ? vs.getValue2() : null);
    }


    public void put(K key, V1 value1, V2 value2) {
        if ((key == null) || (value1 == null) || (value2 == null))
            throw new IllegalArgumentException("Arguments cannot be null!");
        MyTwoValueMap.ValueStorage<V1, V2> vs = new ValueStorage<>(value1, value2);
        put(key, vs);
    }

    public void print() {
        for (Entry entry : this.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", " + entry.getValue() + " ");
        }
    }


    //Проходит по всей map и в случае первого несоответствия entry (точнее V1 и V2 ) критерию возвращает false;
    public boolean isMapValid(BiPredicate<V1, V2> criterion) {
        for (Entry<K, ValueStorage<V1, V2>> entry : entrySet()) {
            if (criterion.test(entry.getValue().getValue1(), entry.getValue().getValue2())) continue;
            return false;
        }
        return true;
    }


    //Проходит по всей переданной map и в случае первого несоответствия entry (точнее V1 и V2 ) критерию возвращает false;
    public static <K, V1, V2> boolean isMapDataValid(BiPredicate criterion, MyTwoValueMap<K, V1, V2> myMap) {
        for (Entry<K, ValueStorage<V1, V2>> entry : myMap.entrySet()) {
            if (criterion.test(entry.getValue().getValue1(), entry.getValue().getValue2())) continue;
            return false;
        }
        return true;
    }


    //Проходит по всей переданной map и в случае несоответствия entry (точнее V1 и V2 ) критерию добавляет entry в новую Map
    //Возращает новую Map, содержащую только НЕ валидные даннные
    public static <K, V1, V2> MyTwoValueMap<K, V1, V2> getNotValidData(BiPredicate criterion, MyTwoValueMap<K, V1, V2> myMap) {
        MyTwoValueMap<K, V1, V2> notValidOnly = new MyTwoValueMap<>();
        for (Entry<K, ValueStorage<V1, V2>> entry : myMap.entrySet()) {
            if (!(criterion.test(entry.getValue().getValue1(), entry.getValue().getValue2()))) {
                notValidOnly.put(entry.getKey(), entry.getValue());
            }
        }

        return notValidOnly;
    }

    //Проходит по всей переданной map и в случае несоответствия entry (точнее V1 и V2 ) критерию удаляет entry из map
    //Возвращает int, равный количеству удаленных вхождений.

   public static <K, V1, V2> int removeNotValidData(BiPredicate criterion, MyTwoValueMap<K, V1, V2> myMap) {
       int removedEntries=0;
       Set<Entry<K,ValueStorage<V1,V2>>> entrySet=myMap.entrySet();
       Iterator <Entry<K,ValueStorage<V1,V2>>>  it=entrySet.iterator();
       while (it.hasNext()) {
           Entry<K,ValueStorage<V1,V2>> entry=it.next();
           if (criterion.test(entry.getValue().getValue1(), entry.getValue().getValue2())) continue;
           it.remove();
           removedEntries++;
       }
       return removedEntries;

   }



    //проходит по всей map и проверяет value1, value2 на соответствие критерию валидности. Если соответствует, добавлет в новую map
    //Возвращает новую map, содержащую только валидные данные
    public static <K, V1, V2> MyTwoValueMap<K, V1, V2> getOnlyValidData(BiPredicate criterion, MyTwoValueMap<K, V1, V2> myMap) {
        MyTwoValueMap<K, V1, V2> validOnly = new MyTwoValueMap<>();
        for (Entry<K, ValueStorage<V1, V2>> entry : myMap.entrySet()) {
            if (criterion.test(entry.getValue().getValue1(), entry.getValue().getValue2())) {
                validOnly.put(entry.getKey(), entry.getValue());
            }
        }
        return validOnly;

    }


    protected static class ValueStorage<V1, V2> {
        private V1 value1;
        private V2 value2;


        public ValueStorage(V1 value1, V2 value2) {
            this.value1 = value1;
            this.value2 = value2;
        }


        public V1 getValue1() {
            return value1;
        }

        public void setValue1(V1 value1) {
            this.value1 = value1;
        }

        public V2 getValue2() {
            return value2;
        }

        public void setValue2(V2 value2) {
            this.value2 = value2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ValueStorage that = (ValueStorage) o;

            if (value1 != null ? !value1.equals(that.value1) : that.value1 != null) return false;
            return value2 != null ? value2.equals(that.value2) : that.value2 == null;
        }

        @Override
        public int hashCode() {
            int result = value1 != null ? value1.hashCode() : 0;
            result = 31 * result + (value2 != null ? value2.hashCode() : 0);
            return result;
        }


        @Override
        public String toString() {
            return "value1=" + value1 + ", value2=" + value2;
        }
    }

    public static void main(String[] args) {
        MyTwoValueMap<Integer,String,String> clientData=new MyTwoValueMap<>();
        //пример обработки map, содержащей ID, login и password клиента
        clientData.put(12345,"my12login","myPass1234");
        clientData.put(15777,"my9248login","myPass@55&1234");
        clientData.put(1772345,"my#*login","myPass341723");
        clientData.put(171723,"myNextLogin","myPassword97pw");

        System.out.println("Не валидные entries в исходной map:");
        BiPredicate<String,String> isValid=new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                char[] forbidden=new char[]{'@','#','$','%'};
                if ((s1.length()<=5)||(s2.length()<=5))return false;
                for (char ch:forbidden){
                    if ((s1.indexOf(ch)>=0)||(s2.indexOf(ch)>=0))return false;
                }
                return true;
            }
        };

        MyTwoValueMap<Integer,String,String> notValid=MyTwoValueMap.getNotValidData(isValid,clientData);
        notValid.print();
        System.out.print("Количество удаленных entries:");
        System.out.println(MyTwoValueMap.removeNotValidData(isValid,clientData));
        System.out.println("Map после удаления не валидных данных");
        clientData.print();



        MyTwoValueMap<String,String,Integer> clientsList=new MyTwoValueMap<>();
        //пример обработки map, содержащей Имя и Фамилию, мобильный и количество успешных дозвонов по этому номеру за послпедние 2 года
        clientsList.put("James Hetfield","0503594611",2);
        clientsList.put("Vadim Samoylov","0672725548",4);
        clientsList.put("Gabrielle Chanel","0975523777",0);
        clientsList.put("Alexander Wesselsky","06325O5372",1);
        System.out.print("Удаляю не валидные контактные номера:");
        System.out.println(MyTwoValueMap.removeNotValidData((BiPredicate<String, Integer>) (s, i) -> {
            if (s.length()!=10)return false;
            for (char ch:s.toCharArray()){
                if (ch<48||ch>57)return false;
            }
            return i!=0;
        }, clientsList));
        System.out.println("Map после удаления не валидных данных");
        clientsList.print();



    }




}

