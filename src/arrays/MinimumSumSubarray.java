package arrays;

import static java.lang.Math.min;

public class MinimumSumSubarray {

    public static void main(String[] args){
        int[] array = {3,-4,2,-3,-1,7,-5};
        int i = minimumSubArray(array);
        System.out.println(i);
    }

    /**
     * Another implementation of Kadane's algorithm
     */
    private static int minimumSubArray(int[] arr){
        int subMin = arr[0];
        int minimum = arr[0];

        for(int i=0; i<arr.length; i++){

            subMin = min(arr[i], subMin + arr[i]);

            minimum = min(subMin, minimum);

        }
        return minimum;
    }
}
