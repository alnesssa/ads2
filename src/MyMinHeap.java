public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> heap = new MyArrayList<>(); // Heap storage

    public void insert(T value) {
        heap.addLast(value); // Add to end
        heapifyUp(heap.size() - 1); // Restore heap
    }

    public T extractMin() {
        T min = heap.get(0); // Get root
        heap.set(0, heap.get(heap.size() - 1)); // Move last to root
        heap.removeLast(); // Remove last
        heapifyDown(0); // Restore heap
        return min;
    }

    public T getMin() {
        return heap.get(0); // Return root
    }

    public boolean isEmpty() {
        return heap.size() == 0; // Check if empty
    }

    public int size() {
        return heap.size(); // Return size
    }

    private void heapifyUp(int index) {
        // Move value up to restore heap
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        // Move value down to restore heap
        int left, right, smallest;
        while ((left = 2 * index + 1) < heap.size()) {
            right = left + 1;
            smallest = index;
            if (heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        // Swap elements at i and j
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
