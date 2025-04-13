public class Main {
    public static void main(String[] args) {
        // Stack demo
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Pop: " + stack.pop()); // Should print 20

        // Queue demo
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Queue Dequeue: " + queue.dequeue()); // Should print A

        // MinHeap demo
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        System.out.println("Min Heap Extract: " + heap.extractMin()); // Should print 1
    }
}
