public class MyQueue<T extends Comparable<T>> {

    private MyLinkedList<T> list = new MyLinkedList<>(); // Queue storage

    public void enqueue(T item) {
        list.addLast(item); // Add to end
    }

    public T dequeue() {
        T first = list.getFirst(); // Get front
        list.removeFirst(); // Remove front
        return first;
    }

    public T peek() {
        return list.getFirst(); // View front
    }

    public boolean isEmpty() {
        return list.size() == 0; // Check if empty
    }

    public int size() {
        return list.size(); // Return size
    }
}
