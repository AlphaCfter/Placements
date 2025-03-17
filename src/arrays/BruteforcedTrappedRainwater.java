package arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class BruteforcedTrappedRainwater {

    public static void main(String[] args){
        int[] arr = {0,0,0,2,0,4};
        int i = waterFill(arr);
        System.out.println("The water filled is: "+i);
    }

    private static int waterFill(int[] arr){
        int water =0;

        for(int i=1; i<arr.length-1; i++){

            int left = arr[i];
            for(int j=0; j<i; j++){
                left = max(arr[j], left);
            }

            int right = arr[i];
            for(int j=i+1; j<arr.length; j++){
                right = max(arr[j], right);
            }

            water += min(left,right) - arr[i];
        }

        return water;
    }
}
