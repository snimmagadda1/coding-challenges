package Codility.Arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class SquaresOfSortedArray {

    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    public int[] sortedSquares(int[] nums) {

        // Square each element
        int[] squares = Arrays.stream(nums).map(i -> i*i).toArray();

         // Sort
        Arrays.sort(squares);
        return squares;
    }
    
}
