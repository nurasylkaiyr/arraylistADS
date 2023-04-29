package org.example;
import java.util.NoSuchElementException;
public class MyArrayListQueue<T> {
    private MyArrayList<T> list;
    public MyArrayListQueue(){
        list = new MyArrayList<>();
    }
    public void enqueue(T element) {
        list.add(element);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
    public int size() {
        return list.size();
    }

}
