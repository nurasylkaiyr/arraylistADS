package org.example;
import java.util.EmptyStackException;
public class MyArrayListStack<T> {
    private MyArrayList<T> list;
    public MyArrayListStack(){
        list = new MyArrayList<>();
    }
    public void push(T element) {
        list.add(element);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(size() - 1);
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(size() - 1);
    }
}
