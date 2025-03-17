package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class SortingWithoutAlgoritm {

public static void main(String[] args) {

    ArrayList<Integer> zeros = new ArrayList<>();
    ArrayList<Integer> ones = new ArrayList<>();
    ArrayList<Integer> twos = new ArrayList<>();
    ArrayList<Integer> combined = new ArrayList<>();

    int[] array = new int[20];
    Random rd = new Random();

    for (int n = 0; n < array.length; n++) {
       array[n] = rd.nextInt(3);
    }

    System.out.println("Original Array: " + Arrays.toString(array));

    for (int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            zeros.add(array[i]);
        } else if (array[i] == 1) {
            ones.add(array[i]);
        } else if (array[i] == 2) {
            twos.add(array[i]);
        }
    }

    combined.addAll(zeros);
    combined.addAll(ones);
    combined.addAll(twos);

    Integer[] result = combined.toArray(new Integer[0]);

    System.out.println(Arrays.toString(result));

    }
}
