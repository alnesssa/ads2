public class MyStack<T extends Comparable<T>> {

    private MyArrayList<T> list = new MyArrayList<>(); // Stack storage

    public void push(T item) {
        list.addLast(item); // Add to top
    }

    public T pop() {
        T top = list.getLast(); // Get top
        list.removeLast(); // Remove top
        return top;
    }

    public T peek() {
        return list.getLast(); // View top
    }

    public boolean isEmpty() {
        return list.size() == 0; // Check if empty
    }

    public int size() {
        return list.size(); // Return size
    }
}
