package org.example;
import java.util.EmptyStackException;
public class MyArrayListStack<T> {
    MyArrayList<T> list;
    public MyArrayListStack(){
        list = new MyArrayList<>();
    }
    public void push(T element) {
        list.add(element);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
