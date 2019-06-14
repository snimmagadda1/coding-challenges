package LeetCode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Create map w/ key = num, value = index
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for(int i =0; i <nums.length; i++){
            numberMap.put(nums[i], i);
        }

        // iterate through keyset
        for(int i =0; i<nums.length; i++){
            int compliment = target - nums[i];
            // if map has compliment, and compliment is not the same number, return the index
            if(numberMap.containsKey(compliment) && numberMap.get(compliment) != i){
                int[] ans = {numberMap.get(compliment), i};
                return ans;
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
