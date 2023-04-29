package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Testing MyLinkedList
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

        //Testing MyArrayList
        MyArrayList<Integer> myList = new MyArrayList<>();
        System.out.println("Size:" + myList.size());
        myList.add(6);
        myList.add(4);
        myList.add(1);
        myList.add(10);
        myList.add(6);
        myList.add(5);
        System.out.println("Size after adding elements:" + myList.size());
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        myList.sort();
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        System.out.println(myList.size());
        System.out.println(myList.contains(1));
        System.out.println(myList.contains(2));
        myList.add(8, 2);
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        myList.remove(2);
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        System.out.println(myList.indexOf(6));
        System.out.println(myList.lastIndexOf(6));
    }
}