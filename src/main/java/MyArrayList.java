public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void  add(T element){
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    @Override
    public void add(T element, int index) {
        checkIndex(index);
        if(size == arr.length){
            increaseBuffer();
        }
        for(int i = size - 1; i >= index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
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

    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    public T getElement(int index) {
        checkIndex(index);
        return arr[index];
    }

    public int getSize() {
        return size;
    }
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
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

    public void delete(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}