package org.example;
import java.util.EmptyStackException;
import java.util.LinkedList;
public class MyLinkedListStack<T> {
    private LinkedList<T> list;
    public MyLinkedListStack(){
        list = new LinkedList<>();
    }
    public void push(T element) {
        list.addFirst(element);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
