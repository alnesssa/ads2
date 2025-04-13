import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class Node {
        T data;
        Node next, prev;

        Node(T data) { this.data = data; }
    }

    private Node head, tail; // First and last nodes
    private int size;        // Number of elements in the list

    // Adds an item to the end of the list
    public void add(T item) {
        addLast(item);
    }

    // Adds an item to the beginning
    public void addFirst(T item) {
        Node node = new Node(item);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // Adds an item to the end
    public void addLast(T item) {
        Node node = new Node(item);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // Adds an item at a specific index
    public void add(int index, T item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Node curr = nodeAt(index);
            Node prev = curr.prev;
            Node newNode = new Node(item);
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = curr;
            curr.prev = newNode;
            size++;
        }
    }

    // Replaces the item at the given index
    public void set(int index, T item) {
        nodeAt(index).data = item;
    }

    // Returns the item at the given index
    public T get(int index) {
        return nodeAt(index).data;
    }

    // Returns the first item
    public T getFirst() {
        return head.data;
    }

    // Returns the last item
    public T getLast() {
        return tail.data;
    }

    // Removes the item at the given index
    public void remove(int index) {
        Node node = nodeAt(index);
        if (node == head) removeFirst();
        else if (node == tail) removeLast();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    // Removes the first item
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // list becomes empty
            size--;
        }
    }

    // Removes the last item
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null; // list becomes empty
            size--;
        }
    }

    // Sorts the list using bubble sort
    public void sort() {
        for (int i = 0; i < size; i++) {
            Node current = head;
            for (int j = 0; j < size - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    // Returns the index of the first occurrence of an object
    public int indexOf(Object object) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(object)) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // Returns the index of the last occurrence of an object
    public int lastIndexOf(Object object) {
        Node curr = tail;
        int index = size - 1;
        while (curr != null) {
            if (curr.data.equals(object)) return index;
            curr = curr.prev;
            index--;
        }
        return -1;
    }

    // Checks if an object exists in the list
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Converts the list to an array
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node curr = head;
        int i = 0;
        while (curr != null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    // Clears the list
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Returns the node at the given index
    private Node nodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr;
    }

    // Returns an iterator over the list
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node curr = head;
            public boolean hasNext() { return curr != null; }
            public T next() {
                T val = curr.data;
                curr = curr.next;
                return val;
            }
        };
    }
}
