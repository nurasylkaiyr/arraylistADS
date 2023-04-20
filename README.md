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


