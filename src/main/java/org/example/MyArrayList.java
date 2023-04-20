package org.example;

public class MyArrayList<T> implements MyList<T>{
    private T[] arr; // An array to hold the elements in the list
    private int size; // The number of elements in the list

    MyArrayList(){  // Constructor that initializes the array with a default size of 5 and sets size to 0
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public int size() { // Returns the current size of the list
        return size;
    }

    @Override
    public boolean contains(Object o) {  // Returns true if the specified object is present in the list, false otherwise
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
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

    public void increaseBuffer(){ // This method increases the capacity of the array by doubling its size.
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    @Override
    public void clear(){ // This method clears the array and sets its capacity to 5.
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) { // This method returns the element at the specified index in the array.
        checkIndex(index);
        return(T) arr[index];
    }

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

    @Override
    /* the "sort()" method, which is to sort the elements in the array in ascending order using the natural order of the elements.
    The method uses the bubble sort algorithm, which iterates through the array multiple times, swapping adjacent elements
    if they are in the wrong order until the array is sorted.*/
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

    //This method is a helper method used to validate
    // that the specified index is within the bounds of the current array list
    public void checkIndex(int index){
        if(index < 0 || index>=size){ //  If the index is less than zero or greater than or equal to the current size of the array list
            throw new IndexOutOfBoundsException(); //  an IndexOutOfBoundsException is thrown.
        }
    }
}