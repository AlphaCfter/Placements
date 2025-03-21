package queue;

public class PriorityQueues {

    private int[] values;
    private int[] priorities;
    private int size;
    private final int capacity;

    PriorityQueues(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.priorities = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(int value, int priority) {
        if (size >= capacity) throw new IllegalStateException("The Queue is full");

        values[size] = value;
        priorities[size] = priority;
        size++;

        shiftUp(size - 1);
    }

    private void shiftUp(int i) {
        while (i > 0) {
            int parentIndex = (i - 1) / 2;

            // If the current element's priority is less than or equal to its parent's, we're done
            if (priorities[i] <= priorities[parentIndex]) {
                break;
            }

            // Swap values and priorities if the current element has higher priority
            swap(i, parentIndex);

            // Move to the parent index
            i = parentIndex;
        }
    }

    private void swap(int i, int j) {
        // Swap the values
        int tempValue = values[i];
        values[i] = values[j];
        values[j] = tempValue;

        // Swap the priorities
        int tempPriority = priorities[i];
        priorities[i] = priorities[j];
        priorities[j] = tempPriority;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty");
        }
        return values[0];
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty");
        }

        int highestPriorityValue = values[0];

        // Replace the root with the last element
        values[0] = values[size - 1];
        priorities[0] = priorities[size - 1];
        size--;

        shiftDown(0);
        return highestPriorityValue;
    }

    private void shiftDown(int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < size && priorities[leftChild] > priorities[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && priorities[rightChild] > priorities[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(i, largest);
            shiftDown(largest);
        }
    }
}
