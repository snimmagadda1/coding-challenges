package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length(); j++)
                if (allUnique(s, i, j)){
                    ans = Math.max(ans, j - i);
                }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstringWindow(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < n && j <n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, s.substring(i, j).length());
            } else { // must increment i
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s1 = "ccabcad"; // longest is bcad
        System.out.println(lengthOfLongestSubstringWindow(s1));
    }

}
