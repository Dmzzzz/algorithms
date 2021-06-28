package sort;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {

        int[] array = {4, 10, 3, 20, 4, 2, 27};

        sortAscending(array);
    }

    static void sortAscending(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
