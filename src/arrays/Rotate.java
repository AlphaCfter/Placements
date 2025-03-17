package arrays;

import java.util.Arrays;

public class Rotate {

    public static void rotateByN(int[] array) {
        int temp = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Before rotation");
        System.out.println(Arrays.toString(array));

        rotateByN(array);

        System.out.println("Rotating an array");
        System.out.println(Arrays.toString(array));
    }
}
