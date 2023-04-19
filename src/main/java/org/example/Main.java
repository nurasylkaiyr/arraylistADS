package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("Size: " + list.size());

        list.add(5);
        list.add(10);
        list.add(15);
        System.out.println("Size after adding elements: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));

        list.remove(1);
        System.out.println("Size after removing element at index 1: " + list.size());
        System.out.println("Element at index 1 after removal: " + list.get(1));

        list.add(20, 1);
        System.out.println("Size after adding element at index 1: " + list.size());
        System.out.println("Element at index 1 after addition: " + list.get(1));

        System.out.println("Index of element 15: " + list.indexOf(15));
        System.out.println("Index of element 20: " + list.indexOf(20));
    }
}