package hometask07;

import java.util.Arrays;

/*
Задача: написать свой аналог ArrayList;
Минимальная реализация:
1) add - по индексу и по value
2) remove
3) add
 */

public class MyArrayList<T> {
    private int capacity = 10;
    private int size = 0;
    private Object[] array;


    //Конструктор по умолчанию

    public MyArrayList() {
        array = new Object[capacity];
    }

    //Конструктор с уточнением емкости
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Unacceptable initial capacity value" + initialCapacity);
        capacity = initialCapacity;
        array = new Object[capacity];
    }

    //проверка, есть ли элементы в ArrayList
    public boolean isEmpty() {
        return (size == 0);
    }

    //Получить количество добавленных элементов
    public int size() {
        return size;
    }

    private void ensureCapacity(int addedQuantity) {
        if (size + addedQuantity < capacity) return;
        Object[] oldArray = array;
        capacity = (capacity * 3 / 2) + addedQuantity;
        array = new Object[capacity];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
        oldArray = null;

    }


    public T get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Unacceptable index value " + index);
        return (T) array[index];
    }

    public void add(T t) {
        ensureCapacity(1);
        array[size++] = t;
    }


    public void add(int index, T t) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Unacceptable index value " + index);
        ensureCapacity(1);
        for (int i = size++; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = t;
    }


    //установить элемент на определенный индекс
    public void set(int index, T t) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Unacceptable index value " + index);
        array[index] = t;
    }

    //get index of element first occurrence in arrayList
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) return i;
        }
        return -1;//если не найден такой элемент
    }


    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }


    //удалить элемент, находящийся на определенном индексе
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Unacceptable index value " + index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }


    //удалить первое вхождение заданного элемента
    public boolean remove(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (capacity != that.capacity) return false;
        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + size;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(size * 4);
        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf(array[i])).append(" ");
        }
        return sb.toString();
    }


   /* @Override
    public String toString() {//будут печататься все элементы в рамках capacity, в т.ч. и не заполненные
        return Arrays.toString(array);
    }*/


}
