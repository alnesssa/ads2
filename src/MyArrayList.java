import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Object[] elements; // Internal array to store elements
    private int size;          // Number of elements in the list

    // Creates an empty list with initial capacity 10
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // Doubles the array size when full
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArr = new Object[size * 2];
            for (int i = 0; i < size; i++) newArr[i] = elements[i];
            elements = newArr;
        }
    }

    // Adds an item to the end
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    // Adds an item at a specific index
    public void add(int index, T item) {
        checkIndex(index);
        ensureCapacity();
        for (int i = size; i > index; i--) elements[i] = elements[i - 1];
        elements[index] = item;
        size++;
    }

    // Replaces the item at the index
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    // Adds an item at the beginning
    public void addFirst(T item) {
        add(0, item);
    }

    // Adds an item at the end
    public void addLast(T item) {
        add(item);
    }

    // Returns the item at the index
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Returns the first item
    public T getFirst() {
        return get(0);
    }

    // Returns the last item
    public T getLast() {
        return get(size - 1);
    }

    // Removes the item at the index
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) elements[i] = elements[i + 1];
        size--;
    }

    // Removes the first item
    public void removeFirst() {
        remove(0);
    }

    // Removes the last item
    public void removeLast() {
        remove(size - 1);
    }

    // Sorts the list using bubble sort
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (((T) elements[j - 1]).compareTo((T) elements[j]) > 0) {
                    T temp = (T) elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                }
            }
        }
    }

    // Returns the first index of the object
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(object)) return i;
        return -1;
    }

    // Returns the last index of the object
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--)
            if (elements[i].equals(object)) return i;
        return -1;
    }

    // Checks if an object exists
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Converts the list to an array
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = elements[i];
        return result;
    }

    // Clears the list
    public void clear() {
        size = 0;
        elements = new Object[10];
    }

    // Returns current size
    public int size() {
        return size;
    }

    // Validates the index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    // Returns an iterator over the list
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) elements[index++];
            }
        };
    }
}
