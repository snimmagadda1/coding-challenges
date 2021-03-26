package Codility.Arrays;

import java.util.Arrays;

public class DuplicateZeros {

    // [1,0,2,3,0,4,5,0]
    public static void duplicateZeros(int[] arr) {
        long numZeros = Arrays.stream(arr).filter(el -> el == 0).count();
        int[] toReturn = new int[(int) numZeros + arr.length];
        // iterate over original
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            // if zero, increment counter and set next val to 0
            if (arr[i] == 0) {
                toReturn[j] = 0;
                j++;
                toReturn[j] = 0;
            } else {
                toReturn[j] = arr[i];
            }

            j++;

        }

        arr = toReturn.clone();
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,0,2,3,0,4,5,0};
        duplicateZeros(input);
    }
}
