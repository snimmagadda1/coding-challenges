package Codility.Arrays;


// Input: nums = [12,345,2,6,7896]
// Output: 2
public class FindNumbers {
    public int findNumbers(int[] nums) {
        int count = 0;
        // Iterate over nms 
        for (int i =0; i < nums.length; i++) {
            int curr = nums[i];
            // int length = String.valueOf(curr).length(); THIS IS EXPENSIVE
            int length = (int) (Math.log10(curr) + 1);
            if (length % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
