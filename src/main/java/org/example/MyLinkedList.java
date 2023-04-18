package org.example;

public class MyLinkedList<T> implements MyList<T> {
    private class Node{
        private T element;
        private Node next;
        private Node prev;
        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T element) {
        Node node = new Node(element);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node(element);
        if(index == 0){
            node.next = head;
            head.prev = node;
            head = node;
        }
        else if(index == size){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }
        size++;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
