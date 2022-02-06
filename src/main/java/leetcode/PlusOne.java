package leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        int[] arr = {2, 9, 9};

        System.out.println(Arrays.toString(plusOne(arr)));

    }

    public static int[] plusOne(int[] arr) {
        int lastIndex = arr.length - 1;

        while (arr[lastIndex] == 9) {
            arr[lastIndex] = 0;
            --lastIndex;

            if (lastIndex < 0) {
                arr = new int[arr.length + 1];
                arr[0] = 1;
                break;
            }
        }

        if (lastIndex >= 0) {
            arr[lastIndex]++;
            return arr;
        }
        return arr;
    }
}
