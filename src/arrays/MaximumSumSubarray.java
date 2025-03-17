package arrays;

import java.util.ArrayList;

import static java.lang.Math.max;

/**
 * The MaximumSumSubarray class provides a method to compute
 * the maximum sum of a contiguous subarray within a 1D array of integers
 * using Kadane's Algorithm.
 */
public class MaximumSumSubarray {

    /**
     * Entry point of the program. Demonstrates the usage of the
     * maximumSum method by calculating and printing the
     * maximum sum of a subarray.
     *
     * @param args Standard command-line arguments.
     */
    public static void main(String[] args) {
        // Input array
        int[] array = {-1, -2, -3, -4, -5};
        int n = array.length;

        // Calculate the maximum sum subarray
        int i = maximumSum(array, n);

        // Print the result
        System.out.println(i);
    }

    /**
     * This method calculates the maximum sum of a contiguous subarray within
     * the given input array using Kadane's Algorithm.
     *
     * Algorithm Workflow:
     * 1. The first element serves as the initial `currentMax` and `maximum`.
     * 2. For each subsequent element,:
     *    - Compare the element itself with the sum of `currentMax + arr[i]`.
     *    - Update `currentMax` and determine if `maximum` needs to be updated.
     *
     * Time Complexity: O(n), where `n` is the size of the array.
     *
     * @param arr The input array of integers.
     * @param n The length of the input array.
     * @return The maximum sum of a contiguous subarray.
     */
    private static int maximumSum(int[] arr, int n) {
        // Initialize variables
        int currentMax = arr[0];
        int maximum = arr[0];

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // Update currentMax
            currentMax = max(arr[i], currentMax + arr[i]);
            // Update maximum
            maximum = max(maximum, currentMax);
        }

        // Return the maximum sum
        return maximum;
    }
}