package arrays;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int window = 3;
        slidingWindow(array, window);
    }

    /**
     * Sliding window problem
     *
     * O(n^2) complexity
     *
     * "i" iterate each window's first element
     * <img src="{@docRoot}/doc/SlidingWindowMaximum" alt="Example Image">
     * "j" iterates each element within the window
     *
     * @param array array for init
     * @param window size being defined
     */
    private static void slidingWindow(int[] array, int window) {
        for (int i = 0; i <= array.length - window; i++) {
            int max = array[i];
            for (int j = i + 1; j < i + window; j++) {
                if (array[j] > max) {
                    max = array[j];
                }
            }
            System.out.println(max);
        }
    }
}
