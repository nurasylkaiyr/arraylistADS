package org.example;
import  java.util.NoSuchElementException;
import java.util.LinkedList;
public class MyLinkedListQueue<T> {
    private LinkedList<T> list;
    public MyLinkedListQueue(){
        list = new LinkedList<>();
    }
    public void enqueue(T element) {
        list.addLast(element);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }
}
