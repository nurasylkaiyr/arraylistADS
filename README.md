# List implementation

---
## Desription
The second assignment in the course "Algorithms and Data Structures".
This repository contains jobs related to implementing methods from the List interface in the ArrayList and LinkedList classes.

---
## MyArrayList

MyArrayList is a Java implementation of a dynamic array using a generic type. It provides methods for adding, removing, accessing, and sorting elements in the list.

---

### Adding elements
**add(T element):** This method adds an element to the end of the MyArrayList.

**add(T element, int index):** This method adds an element to the MyArrayList at the specified index, shifting all the elements to the right of the index by one position.

```java
   @Override
    public void  add(T element){  // Adds an element to the end of the list
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    @Override
    public void add(T element, int index) { // Adds an element at the specified index in the list
        checkIndex(index); // Check if the index is valid
        if(size == arr.length){
            increaseBuffer(); // If the array is full, increase its size
        }
        // This method inserts an element at a specified index in the array, shifting all
        // elements to the right of the index by one position, and increasing the size of the array by one.
        for(int i = size - 1; i >= index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        size++;
    }
```

---
### Removing elements
**remove(T element):** This method removes the first occurrence of the specified element from the MyArrayList.

**remove(int index):** This method removes the element at the specified index from the MyArrayList, shifting all the elements to the right of the index by one position.

```java
   @Override
    public boolean remove(T element) { // Removes the first occurrence of the specified element in the array.
        for(int i = 0; i < size; i++){
            if(arr[i].equals(element)){ // It returns true if the element was found and removed, false otherwise.
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) { // This method removes the element at the specified index in the array, shifting
        checkIndex(index);      // all elements to the right of the index by one position, and decreasing the size of the array by one.
        T removed_item = (T) arr[index];
        for(int i = index + 1; i < size; i++){
            arr[i-1] = arr[i];
        }
        size--;
        arr[size] = null;
        return removed_item;
    }
```

---
### Get elements
**get(int index):** This method returns the element at the specified index in the MyArrayList.

```java
      @Override
    public T get(int index) { // This method returns the element at the specified index in the array.
        checkIndex(index);
        return(T) arr[index];
    }
```
---
### Contains method
**contains(Object o):** This method checks whether the specified object is present in the MyArrayList or not. If it is present, the method returns true, otherwise it returns false.

```java
     @Override
    public boolean contains(Object o) {  // Returns true if the specified object is present in the list, false otherwise
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
```

---
### First and last index of elements
indexOf(Object o): This method returns the index of the first occurrence of the specified element in the MyArrayList, or -1 if the element is not found.

lastIndexOf(Object o): This method returns the index of the last occurrence of the specified element in the MyArrayList, or -1 if the element is not found.

```java
  @Override
    public int indexOf(Object o) {    // This method returns the index of the first occurrence of the specified element in the array,
        for(int i = 0; i<size; i++){ // or -1 if the element is not found.
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {     // This method returns the index of the last occurrence of the specified element in the array,
        for(int i = size - 1; i>=0; i--){ // or -1 if the element is not found.
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;

    }
```

---

### Size method
**size():** This method returns the number of elements in the MyArrayList.

```java
      @Override
    public int size() { // Returns the current size of the list
        return size;
    }
```

---
### IncreaseBuffer method
**increaseBuffer():** This method increases the capacity of the MyArrayList by doubling its size.

```java
      public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
```

---
### Clear method
**clear():** This method clears the MyArrayList and sets its capacity to 5.

```java
     @Override
    public void clear(){ // This method clears the array and sets its capacity to 5.
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
```

---
### Sorting elements
**sort():** This method sorts the elements in the MyArrayList in ascending order using the natural order of the elements. The method uses the bubble sort algorithm, which iterates through the array multiple times, swapping adjacent elements
    if they are in the wrong order until the array is sorted.

```java
    public void sort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < size; i++) {
                if (((Comparable) arr[i-1]).compareTo(arr[i]) > 0) {
                    Object temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = (T) temp;
                    swap = true;
                }
            }
        }
    }
```

---

## MyLinkedList

A generic doubly linked list class that implements the MyList<T> interface. It has a nested private class Node that represents a node in the linked list. Each node contains an element of type T and references to the next and previous nodes. The class has three instance variables:

**head:** a reference to the first node in the list
**tail:** a reference to the last node in the list
**size:** the number of nodes in the list

---
### Adding elements
**add(T element): void:** This method adds a new node to the end of the linked list with the given element.

**add(T element, int index):** void: This method adds a new node with the given element at the specified index of the linked list. It throws an IndexOutOfBoundsException if the index is out of bounds.

```java
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
```

---
### Removing elements

**remove(T item):** boolean: This method removes the first occurrence of the given element from the linked list. It returns true if the element is found and removed, otherwise false.

**remove(int index):** This method removes and returns the element at the specified index of the linked list. It throws an IndexOutOfBoundsException if the index is out of bounds.

```java
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
```

---
### Contains method

**contains(Object o):** boolean: This method checks whether a particular object is present in the list or not. It returns true if the object is found, otherwise false.

```java
      @Override
    // This method used to check whether a particular object is present in a list or not.
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

```

---
### Clear method

**clear():** This method resets the state of the object by setting its head and tail pointers to null and its size to zero. This effectively removes all elements from the object's collection, allowing it to be reused for a new collection of elements.

```java
 @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
```

---
### Get method

**get():** This method for a doubly linked list. The method takes an index as an argument and returns the element at that index. The method first checks if the index is within the bounds of the linked list by comparing it with the size of the list. If the index is out of bounds, an IndexOutOfBoundsException is thrown.

Then the method traverses the linked list from either the head or tail, depending on the index, until it reaches the node at the specified index. If the index is less than the middle of the list, the traversal starts from the head. Otherwise, the traversal starts from the tail. Finally, the method returns the element of the node at the specified index. 

```java
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
```

---
### First and last index of elements

**indexOf():** This method starts at the head of the linked list and traverses it until it finds the first occurrence of the object, and then returns the index of that node. If the object is not found, it returns -1.

**lastIndexOf():** This method starts at the tail of the linked list and traverses it backwards until it finds the last occurrence of the object, and then returns the index of that node. If the object is not found, it returns -1.

```java
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
```

### Sorting elements

**sort():** This method is an implementation of a sorting algorithm for a linked list data structure. It uses a modified version of the bubble sort algorithm, which repeatedly traverses the linked list, compares adjacent elements and swaps them if they are in the wrong order. The method starts by checking if the size of the linked list is less than or equal to 1, in which case it returns immediately. It then enters a do-while loop that keeps iterating over the linked list until no more swaps are needed, indicating that the list is sorted. Within the loop, the method uses a temporary variable to swap elements if necessary. The Comparable interface is used to compare elements in the linked list.

```java
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
```
---
## Contributing

Contributions to this repository are welcome. If you notice a bug or have an idea for an improvement, please open an issue or submit a pull request.
