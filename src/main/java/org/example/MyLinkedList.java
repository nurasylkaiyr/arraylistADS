package org.example;

public class MyLinkedList<T> implements MyList<T> {

    /*
     This is a private class that represents a node in the linked list.
     Each node contains an element of type T and references to the next and previous nodes.
     */
    private class Node{
        T element; // The element stored in this node
        Node next; // Reference to the next node in the list
        Node prev; // Reference to the previous node in the list

        /*
         Constructor to create a new Node with the given element.
         The next and prev references are initially set to null.
         */
        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head; // Reference to the first node in the list
    private Node tail; // Reference to the last node in the list
    private int size; // The number of nodes in the list

    /*
     Constructor to create a new empty MyLinkedList object.
     The head and tail references are initially set to null, and the size is set to 0.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    } // Returns the current size of the list

    @Override
    // This method used to check whether a particular object is present in a list or not.
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(T element) {
        Node node = new Node(element); // Create a new node to hold the element
        if(head == null){ // If the linked list is empty, set the head and tail to the new node
            head = node;
            tail = node;
        }
        else{ // If the linked list is not empty, add the new node to the end of the list
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++; // Increase the size of the linked list
    }

    @Override
    public void add(T element, int index) {
        if(index < 0 || index > size) { // Check if the index is valid
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node(element); // Create a new node to hold the element
        if(index == 0){ // If the index is 0, add the new node to the beginning of the linked list
            node.next = head;
            head.prev = node;
            head = node;
        }
        else if(index == size){ // If the index is the size of the linked list, add the new node to the end of the linked list
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else { // If the index is in the middle of the linked list, add the new node to the specified index
            Node current = head; // Traverse the linked list to the specified index
            for (int i = 0; i < index; i++) {
                current = current.next;
            } // Add the new node to the specified index by adjusting the pointers of the neighboring
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }
        size++; // Increase the size of the linked list
    }

    @Override
    public boolean remove(T item) {
        Node current = head; // start from the head of the list

        while (current != null) { // iterate over the list
            if (current.element.equals(item)) {  // if the current node's element matches the given item
                if (current.prev == null) { // if the current node is the head of the list
                    head = current.next;  // set the head to the next node
                    if (head != null) {
                        head.prev = null; //if there is a new head nodeset its previous reference to null
                    } else { // otherwise, the list is empty
                        tail = null; // set the tail reference to null as well
                    }
                } else if (current.next == null) { // if the current node is the tail of the list
                    tail = current.prev; // set the tail to the previous node
                    tail.next = null;  // set the new tail's next reference to null
                } else { // if the current node is in the middle of the list
                    current.prev.next = current.next;  // set the previous node's next reference to the next
                    current.next.prev = current.prev; // set the next node's previous reference to the previous node
                }
                size--; // decrement the size of the list
                return true; // indicate that the element was successfully removed
            }
            current = current.next; // move to the next node in the list
        }
        return false; // indicate that the element was not found in the list
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) { // method first checks if the index is within the bounds of the linked list
            throw new IndexOutOfBoundsException(); // and throws an IndexOutOfBoundsException if it is not
        }
        //It then proceeds to remove the node at the specified index, updating the head and tail references if necessary.
        Node current;

        if (index == 0) {
            current = head;
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                int count = 0;
                while (count < index) {
                    current = current.next;
                    count++;
                }
            } else {
                current = tail;
                int count = size - 1;
                while (count > index) {
                    current = current.prev;
                    count--;
                }
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        // decrements the size of the linked list and returns the removed element.
        size--;
        return (T) current.element;
    }

    /*
        The clear() method simply sets the head, tail,
        and size variables to null and 0, respectively,
        effectively removing all elements from the linked list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) { // This method first checks if the index is within the bounds of the linked list
        if (index < 0 || index >= size) { // throws an IndexOutOfBoundsException if it is not
            throw new IndexOutOfBoundsException();
        }
        // traverses the linked list from either the head or tail depending on the index,
        // until it reaches the node at the specified index,
        Node current;
        int count;

        if (index < size / 2) {
            current = head;
            count = 0;
            while (count < index) {
                current = current.next;
                count++;
            }
        } else {
            current = tail;
            count = size - 1;
            while (count > index) {
                current = current.prev;
                count--;
            }
        }

        return (T) current.element; // returns its element.
    }
    /*
        The indexOf(Object o) and lastIndexOf(Object o) methods traverse the linked list from the head and tail,
        respectively, until they find the first or last occurrence
         of the specified element, returning its index or -1 if it is not found.
     */
    @Override
    public int indexOf(Object o) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        Node curr = tail;
        int index = size - 1;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }
    /*
    The sort() method implements the bubble sort algorithm to sort the elements in the linked list in ascending order,
    using the compareTo() method of the elements. It first checks
    if the size of the linked list is less than or equal to 1,
    in which case the list is already sorted.
    , it repeatedly compares adjacent elements and swaps them if they are out of order,
    until no more swaps are needed.
     */

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != null) {
                if (((Comparable<T>) (T) curr.element).compareTo((T)curr.next.element) > 0) {
                    // Swap elements
                    T temp = (T) curr.element;
                    curr.element = curr.next.element;
                    curr.next.element = (T) temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }
}
